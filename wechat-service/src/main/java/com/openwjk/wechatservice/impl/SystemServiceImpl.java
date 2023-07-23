package com.openwjk.wechatservice.impl;

import com.google.common.collect.Lists;
import com.openwjk.wechatservice.serivice.SystemService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemServiceImpl implements SystemService {
    private static final String TOKEN = "wechat";
    /**
     * 16进制 : 16
     */
    private static final int HEX = 16;
    /**
     * SHA: 0xFF
     */
    private static final int SHA_FF = 0xFF;
    /**
     * SHA: 0x100
     */
    private static final int SHA_100 = 0x100;

    @Override
    public String checkRun() {
        return "success.";
    }

    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        List<String> list = Lists.newArrayList(timestamp, nonce, TOKEN);
        list = list.stream().sorted().collect(Collectors.toList());
        list.stream().collect(Collectors.joining());
        String str = list.stream().collect(Collectors.joining());
        // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return signature.equals(encryptSHA(str));
    }

    /**
     * SHA算法实现
     *
     * @param msg 明文
     * @return 密文
     */
    public static String encryptSHA(final String msg) {

        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(msg.getBytes());
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & SHA_FF) + SHA_100, HEX).substring(1));
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
