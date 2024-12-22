package com.gameloft.android2d.socialnetwork;

import android.os.Handler;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.RequestBatch;
import com.facebook.Response;
import com.facebook.internal.CacheableRequestBatch;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphUser;
import java.util.Collection;
import org.json.JSONObject;

public final class C0521e<T extends GraphObject> {
    C0526j afs;
    C0527k<T> aft;
    private C0520d<T> afu;
    Request currentRequest;
    private final Class<T> graphObjectClass;
    Request nextRequest;
    Request originalRequest;
    boolean skipRoundtripIfCached;
    boolean appendResults = false;
    boolean loading = false;
    boolean afv = false;
    private String afw = "";
    Response afx = null;

    public C0521e(Class<T> cls) {
        this.graphObjectClass = cls;
    }

    static void m2776a(C0521e c0521e, Response response) {
        if (response.getRequest() == c0521e.currentRequest) {
            c0521e.loading = false;
            c0521e.currentRequest = null;
            FacebookRequestError error = response.getError();
            FacebookException exception = error == null ? null : error.getException();
            if (response.getGraphObject() == null && exception == null) {
                exception = new FacebookException("GraphObjectPagingLoader received neither a result nor an error.");
            }
            if (exception != null) {
                String str = "Facebook: exception:" + exception.toString();
                c0521e.nextRequest = null;
                if (c0521e.afs != null) {
                    C0526j c0526j = c0521e.afs;
                }
                SocialNetwork_Facebook.agr = true;
                SocialNetwork_Facebook.ags = true;
                return;
            }
            try {
                c0521e.addResults(response);
            } catch (Exception e) {
                String str2 = "Facebook: no friends " + e.toString();
                SocialNetwork_Facebook.agr = true;
                SocialNetwork_Facebook.ags = true;
            }
        }
    }

    static CacheableRequestBatch putRequestIntoBatch(Request request, boolean z) {
        CacheableRequestBatch cacheableRequestBatch = new CacheableRequestBatch(request);
        cacheableRequestBatch.setForceRoundTrip(z ? false : true);
        return cacheableRequestBatch;
    }

    void addResults(Response response) {
        Collection<GraphUser> collection;
        boolean z;
        boolean z2;
        try {
            if (this.afv) {
                response.getGraphObject().setInnerJSONObject(new JSONObject(this.afw));
            } else {
                this.afw = response.getGraphObject().getInnerJSONObject().toString();
            }
        } catch (Exception e) {
            String str = "Facebook: pieces error " + e.toString();
        }
        boolean z3 = this.afw.indexOf("{\"data\":[],") >= 0;
        String substring = this.afw.substring("{\"data\":[".length(), this.afw.indexOf(":", "{\"data\":[".length()) + 1);
        int i = -1;
        for (int i2 = 0; i2 < 50 && (i = this.afw.indexOf("," + substring, i + 1)) != -1; i2++) {
        }
        if (i >= 0) {
            try {
                String str2 = this.afw.substring(0, i) + this.afw.substring(this.afw.lastIndexOf("],\"paging\":"));
                this.afw = this.afw.substring(0, this.afw.indexOf(substring)) + this.afw.substring(i + 1);
                response.getGraphObject().setInnerJSONObject(new JSONObject(str2));
            } catch (Exception e2) {
                String str3 = "Facebook: response error " + e2.toString();
            }
            this.afv = true;
            this.afx = response;
        } else {
            this.afv = false;
            this.afx = null;
        }
        C0520d<GraphUser> c0520d = (this.afu == null || !this.appendResults) ? new C0520d<>() : new C0520d<>(this.afu);
        if (z3) {
            collection = null;
            z = false;
            z2 = false;
        } else {
            InterfaceC0530n interfaceC0530n = (InterfaceC0530n) response.getGraphObjectAs(InterfaceC0530n.class);
            z2 = response.getIsFromCache();
            GraphObjectList<U> castToListOf = interfaceC0530n.getData().castToListOf(this.graphObjectClass);
            z = castToListOf.size() > 0;
            collection = castToListOf;
        }
        if (z) {
            this.nextRequest = response.getRequestForPagedResults(Response.PagingDirection.NEXT);
            c0520d.addGraphObjects(collection, z2);
            c0520d.moreObjectsAvailable = true;
        }
        if (!z) {
            c0520d.moreObjectsAvailable = false;
            c0520d.fromCache = z2;
            SocialNetwork_Facebook.ags = true;
            this.nextRequest = null;
        }
        if (!z2) {
            this.skipRoundtripIfCached = false;
        }
        SocialNetwork_Facebook.agl = c0520d;
        String str4 = "Facebook: " + SocialNetwork_Facebook.agl.graphObjects.size() + "friends";
        C0520d<T> c0520d2 = this.afu;
        this.afu = c0520d;
        if (c0520d2 != null && c0520d2 != c0520d && !c0520d2.closed) {
            c0520d2.closed = true;
        }
        this.aft.m2777a(this, this.afu);
        System.gc();
    }

    public final void followNextLink() {
        if (this.afv) {
            this.appendResults = true;
            this.currentRequest = this.nextRequest;
            new Thread(new RunnableC0522f(this)).start();
        } else if (this.nextRequest != null) {
            this.appendResults = true;
            this.currentRequest = this.nextRequest;
            this.currentRequest.setCallback(new C0523g(this));
            this.loading = true;
            try {
                this.currentRequest.executeAndWait();
            } catch (Exception e) {
                Request.executeBatchAsync((RequestBatch) putRequestIntoBatch(this.currentRequest, this.skipRoundtripIfCached));
            }
        }
    }

    void startLoading(Request request, boolean z, long j) {
        this.skipRoundtripIfCached = z;
        this.appendResults = false;
        this.nextRequest = null;
        this.currentRequest = request;
        this.currentRequest.setCallback(new C0524h(this));
        this.loading = true;
        RunnableC0525i runnableC0525i = new RunnableC0525i(this, putRequestIntoBatch(request, z));
        if (j == 0) {
            runnableC0525i.run();
        } else {
            new Handler().postDelayed(runnableC0525i, j);
        }
    }
}
