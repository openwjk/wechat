package com.openwjk.wechatservice.serivice;

public interface SystemService {
    String checkRun();

    boolean checkSignature(String signature, String timestamp, String nonce);
}
