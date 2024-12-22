package com.facebook;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.Session;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TestSession extends Session {
    static final boolean $assertionsDisabled;
    private static final String LOG_TAG = "FacebookSDK.TestSession";
    private static Map<String, TestAccount> appTestAccounts = null;
    private static final long serialVersionUID = 1;
    private static String testApplicationId;
    private static String testApplicationSecret;
    private final Mode mode;
    private final List<String> requestedPermissions;
    private final String sessionUniqueUserTag;
    private String testAccountId;
    private boolean wasAskedToExtendAccessToken;

    interface FqlResponse extends GraphObject {
        GraphObjectList<FqlResult> getData();
    }

    interface FqlResult extends GraphObject {
        GraphObjectList<GraphObject> getFqlResultSet();
    }

    enum Mode {
        PRIVATE,
        SHARED
    }

    interface TestAccount extends GraphObject {
        String getAccessToken();

        String getId();

        String getName();

        void setName(String str);
    }

    final class TestTokenCachingStrategy extends TokenCachingStrategy {
        private Bundle bundle;

        private TestTokenCachingStrategy() {
        }

        @Override
        public final void clear() {
            this.bundle = null;
        }

        @Override
        public final Bundle load() {
            return this.bundle;
        }

        @Override
        public final void save(Bundle bundle) {
            this.bundle = bundle;
        }
    }

    interface UserAccount extends GraphObject {
        String getName();

        String getUid();

        void setName(String str);
    }

    static {
        $assertionsDisabled = !TestSession.class.desiredAssertionStatus() ? true : $assertionsDisabled;
    }

    TestSession(Activity activity, List<String> list, TokenCachingStrategy tokenCachingStrategy, String str, Mode mode) {
        super(activity, testApplicationId, tokenCachingStrategy);
        Validate.notNull(list, "permissions");
        Validate.notNullOrEmpty(testApplicationId, "testApplicationId");
        Validate.notNullOrEmpty(testApplicationSecret, "testApplicationSecret");
        this.sessionUniqueUserTag = str;
        this.mode = mode;
        this.requestedPermissions = list;
    }

    public static TestSession createSessionWithPrivateUser(Activity activity, List<String> list) {
        return createTestSession(activity, list, Mode.PRIVATE, null);
    }

    public static TestSession createSessionWithSharedUser(Activity activity, List<String> list) {
        return createSessionWithSharedUser(activity, list, null);
    }

    public static TestSession createSessionWithSharedUser(Activity activity, List<String> list, String str) {
        return createTestSession(activity, list, Mode.SHARED, str);
    }

    private TestAccount createTestAccountAndFinishAuth() {
        Bundle bundle = new Bundle();
        bundle.putString("installed", "true");
        bundle.putString("permissions", getPermissionsString());
        bundle.putString("access_token", getAppAccessToken());
        if (this.mode == Mode.SHARED) {
            bundle.putString("name", String.format("Shared %s Testuser", getSharedTestAccountIdentifier()));
        }
        Response executeAndWait = new Request(null, String.format("%s/accounts/test-users", testApplicationId), bundle, HttpMethod.POST).executeAndWait();
        FacebookRequestError error = executeAndWait.getError();
        TestAccount testAccount = (TestAccount) executeAndWait.getGraphObjectAs(TestAccount.class);
        if (error != null) {
            finishAuthOrReauth(null, error.getException());
            return null;
        }
        if (!$assertionsDisabled && testAccount == null) {
            throw new AssertionError();
        }
        if (this.mode == Mode.SHARED) {
            testAccount.setName(bundle.getString("name"));
            storeTestAccount(testAccount);
        }
        finishAuthWithTestAccount(testAccount);
        return testAccount;
    }

    private static synchronized TestSession createTestSession(Activity activity, List<String> list, Mode mode, String str) {
        TestSession testSession;
        synchronized (TestSession.class) {
            if (Utility.isNullOrEmpty(testApplicationId) || Utility.isNullOrEmpty(testApplicationSecret)) {
                throw new FacebookException("Must provide app ID and secret");
            }
            testSession = new TestSession(activity, Utility.isNullOrEmpty(list) ? Arrays.asList("email", "publish_actions") : list, new TestTokenCachingStrategy(), str, mode);
        }
        return testSession;
    }

    private void deleteTestAccount(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("access_token", str2);
        Response executeAndWait = new Request(null, str, bundle, HttpMethod.DELETE).executeAndWait();
        FacebookRequestError error = executeAndWait.getError();
        GraphObject graphObject = executeAndWait.getGraphObject();
        if (error != null) {
            Log.w(LOG_TAG, String.format("Could not delete test account %s: %s", str, error.getException().toString()));
        } else if (graphObject.getProperty(Response.NON_JSON_RESPONSE_PROPERTY) == Boolean.valueOf($assertionsDisabled)) {
            Log.w(LOG_TAG, String.format("Could not delete test account %s: unknown reason", str));
        }
    }

    private void findOrCreateSharedTestAccount() {
        TestAccount findTestAccountMatchingIdentifier = findTestAccountMatchingIdentifier(getSharedTestAccountIdentifier());
        if (findTestAccountMatchingIdentifier != null) {
            finishAuthWithTestAccount(findTestAccountMatchingIdentifier);
        } else {
            createTestAccountAndFinishAuth();
        }
    }

    private static synchronized TestAccount findTestAccountMatchingIdentifier(String str) {
        TestAccount testAccount;
        synchronized (TestSession.class) {
            retrieveTestAccountsForAppIfNeeded();
            Iterator<TestAccount> it = appTestAccounts.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    testAccount = null;
                    break;
                }
                testAccount = it.next();
                if (testAccount.getName().contains(str)) {
                    break;
                }
            }
        }
        return testAccount;
    }

    private void finishAuthWithTestAccount(TestAccount testAccount) {
        this.testAccountId = testAccount.getId();
        finishAuthOrReauth(AccessToken.createFromString(testAccount.getAccessToken(), this.requestedPermissions, AccessTokenSource.TEST_USER), null);
    }

    static final String getAppAccessToken() {
        return testApplicationId + "|" + testApplicationSecret;
    }

    private String getPermissionsString() {
        return TextUtils.join(",", this.requestedPermissions);
    }

    private String getSharedTestAccountIdentifier() {
        return validNameStringFromInteger((this.sessionUniqueUserTag != null ? this.sessionUniqueUserTag.hashCode() & 4294967295L : 0L) ^ (getPermissionsString().hashCode() & 4294967295L));
    }

    public static synchronized String getTestApplicationId() {
        String str;
        synchronized (TestSession.class) {
            str = testApplicationId;
        }
        return str;
    }

    public static synchronized String getTestApplicationSecret() {
        String str;
        synchronized (TestSession.class) {
            str = testApplicationSecret;
        }
        return str;
    }

    private static synchronized void populateTestAccounts(Collection<TestAccount> collection, Collection<UserAccount> collection2) {
        synchronized (TestSession.class) {
            Iterator<TestAccount> it = collection.iterator();
            while (it.hasNext()) {
                storeTestAccount(it.next());
            }
            for (UserAccount userAccount : collection2) {
                TestAccount testAccount = appTestAccounts.get(userAccount.getUid());
                if (testAccount != null) {
                    testAccount.setName(userAccount.getName());
                }
            }
        }
    }

    private static synchronized void retrieveTestAccountsForAppIfNeeded() {
        synchronized (TestSession.class) {
            if (appTestAccounts == null) {
                appTestAccounts = new HashMap();
                String format = String.format("SELECT id,access_token FROM test_account WHERE app_id = %s", testApplicationId);
                Bundle bundle = new Bundle();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("test_accounts", format);
                    jSONObject.put("users", "SELECT uid,name FROM user WHERE uid IN (SELECT id FROM #test_accounts)");
                    bundle.putString("q", jSONObject.toString());
                    bundle.putString("access_token", getAppAccessToken());
                    Response executeAndWait = new Request(null, "fql", bundle, null).executeAndWait();
                    if (executeAndWait.getError() != null) {
                        throw executeAndWait.getError().getException();
                    }
                    GraphObjectList<FqlResult> data = ((FqlResponse) executeAndWait.getGraphObjectAs(FqlResponse.class)).getData();
                    if (data == null || data.size() != 2) {
                        throw new FacebookException("Unexpected number of results from FQL query");
                    }
                    populateTestAccounts(data.get(0).getFqlResultSet().castToListOf(TestAccount.class), data.get(1).getFqlResultSet().castToListOf(UserAccount.class));
                } catch (JSONException e) {
                    throw new FacebookException(e);
                }
            }
        }
    }

    public static synchronized void setTestApplicationId(String str) {
        synchronized (TestSession.class) {
            if (testApplicationId != null && !testApplicationId.equals(str)) {
                throw new FacebookException("Can't have more than one test application ID");
            }
            testApplicationId = str;
        }
    }

    public static synchronized void setTestApplicationSecret(String str) {
        synchronized (TestSession.class) {
            if (testApplicationSecret != null && !testApplicationSecret.equals(str)) {
                throw new FacebookException("Can't have more than one test application secret");
            }
            testApplicationSecret = str;
        }
    }

    private static synchronized void storeTestAccount(TestAccount testAccount) {
        synchronized (TestSession.class) {
            appTestAccounts.put(testAccount.getId(), testAccount);
        }
    }

    private String validNameStringFromInteger(long j) {
        String l = Long.toString(j);
        StringBuilder sb = new StringBuilder("Perm");
        char[] charArray = l.toCharArray();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 == c) {
                c2 = (char) (c2 + '\n');
            }
            sb.append((char) ((c2 + 'a') - 48));
            i++;
            c = c2;
        }
        return sb.toString();
    }

    @Override
    void authorize(Session.AuthorizationRequest authorizationRequest) {
        if (this.mode == Mode.PRIVATE) {
            createTestAccountAndFinishAuth();
        } else {
            findOrCreateSharedTestAccount();
        }
    }

    @Override
    void extendAccessToken() {
        this.wasAskedToExtendAccessToken = true;
        super.extendAccessToken();
    }

    void fakeTokenRefreshAttempt() {
        setCurrentTokenRefreshRequest(new Session.TokenRefreshRequest());
    }

    void forceExtendAccessToken(boolean z) {
        AccessToken tokenInfo = getTokenInfo();
        setTokenInfo(new AccessToken(tokenInfo.getToken(), new Date(), tokenInfo.getPermissions(), AccessTokenSource.TEST_USER, new Date(0L)));
        setLastAttemptedTokenExtendDate(new Date(0L));
    }

    public final String getTestUserId() {
        return this.testAccountId;
    }

    boolean getWasAskedToExtendAccessToken() {
        return this.wasAskedToExtendAccessToken;
    }

    @Override
    void postStateChange(SessionState sessionState, SessionState sessionState2, Exception exc) {
        String str = this.testAccountId;
        super.postStateChange(sessionState, sessionState2, exc);
        if (sessionState2.isClosed() && str != null && this.mode == Mode.PRIVATE) {
            deleteTestAccount(str, getAppAccessToken());
        }
    }

    @Override
    boolean shouldExtendAccessToken() {
        boolean shouldExtendAccessToken = super.shouldExtendAccessToken();
        this.wasAskedToExtendAccessToken = $assertionsDisabled;
        return shouldExtendAccessToken;
    }

    @Override
    public final String toString() {
        return "{TestSession testUserId:" + this.testAccountId + " " + super.toString() + "}";
    }
}
