package com.p020a.p021a.p022a;

import com.amazon.android.framework.task.command.AbstractCommandTask;
import com.amazon.android.licensing.LicenseFailurePromptContentMapper;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractC0121h extends AbstractCommandTask {

    private final String f100aN;

    final Map<String, Object> f101aO;

    AbstractC0121h(String str, String str2, String str3) {
        new LicenseFailurePromptContentMapper();
        this.f100aN = str3;
        this.f101aO = new HashMap();
        this.f101aO.put("requestId", this.f100aN);
        this.f101aO.put("sdkVersion", "1.0");
    }
}
