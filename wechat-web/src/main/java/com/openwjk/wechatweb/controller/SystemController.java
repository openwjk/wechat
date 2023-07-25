package com.openwjk.wechatweb.controller;

import com.openwjk.commons.utils.StackTraceUtil;
import com.openwjk.wechatservice.serivice.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author wangjunkai
 * @description
 * @date 2023/7/21 13:24
 */
@RestController
@RequestMapping("/")
@Slf4j
public class SystemController {

    @Autowired
    SystemService systemService;

    @GetMapping
    public String wechat(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        log.info("signature: {} nonce: {} echostr: {} timestamp: {}", signature, nonce, echostr, timestamp);
        if (systemService.checkSignature(signature,timestamp,nonce)) {
            return echostr;
        }
        return "success.";
    }

    @GetMapping("/check.htm")
    public String checkRun() {
        log.info("success.");
        return systemService.checkRun();
    }

}
