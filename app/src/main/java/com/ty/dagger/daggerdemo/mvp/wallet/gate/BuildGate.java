package com.ty.dagger.daggerdemo.mvp.wallet.gate;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by ty on 2018/5/3.
 */

public class BuildGate {
    public static final String KEY = "";
    public static final String SECRETE = "";

    public static final String URL = "https://api.gateio.io/api2/1/private/balances";

    public static Map<String, String> getHeaders() {
        Map<String, String> params = new HashMap<String, String>();
        Mac mac = null;
        SecretKeySpec secretKeySpec = null;
        String postData = "";
        secretKeySpec = new SecretKeySpec(SECRETE.getBytes(Charset.forName("utf-8")), "HmacSHA512");
        try {
            mac = Mac.getInstance("HmacSHA512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            mac.init(secretKeySpec);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        params.put("key",KEY);
        params.put("Sign",byteArrayToHexString(mac.doFinal(postData.getBytes(Charset.forName("utf-8")))));
        return params;
    }


    public static String getUrl() {
        return URL;
    }
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;

        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString();
    }
}
