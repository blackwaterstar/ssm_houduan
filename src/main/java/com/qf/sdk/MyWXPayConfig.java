package com.qf.sdk;

import java.io.InputStream;

public class MyWXPayConfig extends WXPayConfig {
    String getAppID() {
        return "wx632c8f211f8122c6";
    }

    String getMchID() {
        return "1497984412";
    }

    String getKey() {
        return "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC";
    }

    InputStream getCertStream() {
        return null;
    }

    IWXPayDomain getWXPayDomain() {

        MyWXPayDomain myWXPayDomain = new MyWXPayDomain();

        return myWXPayDomain;
    }
}
