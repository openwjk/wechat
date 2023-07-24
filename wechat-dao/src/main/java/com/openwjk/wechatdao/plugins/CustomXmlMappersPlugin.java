package com.openwjk.wechatdao.plugins;

import org.mybatis.generator.api.PluginAdapter;

import java.util.List;

/**
 * @author wangjunkai
 * @description
 * @date 2023/7/24 17:49
 */
public class CustomXmlMappersPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }
}
