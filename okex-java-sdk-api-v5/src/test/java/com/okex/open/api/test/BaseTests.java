package com.okex.open.api.test;

import com.alibaba.fastjson.JSON;
import com.okex.open.api.config.APIConfiguration;
import org.slf4j.Logger;

public class BaseTests {

    public APIConfiguration config;

    public void toResultString(Logger log, String flag, Object object) {
        StringBuilder su = new StringBuilder();
        su.append("\n").append("=====>").append(flag).append(":\n").append(JSON.toJSONString(object));
        log.info(su.toString());
    }
}
