package com.openwjk.wechatservice.impl;

import com.openwjk.wechatservice.serivice.SystemService;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {
    @Override
    public String checkRun() {
        return "success.";
    }
}
