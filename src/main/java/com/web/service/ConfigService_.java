package com.web.service;

import com.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chuqian
 * @Date created in 2019/2/20 23:06
 * @describe html调用thymeleaf 实现参数管理
 */
/*@Service("config")*/
public class ConfigService_ {

    @Autowired
    private ConfigService configService;

    /**
     * 根据键名查询参数配置信息
     * @param configKey 参数名称
     * @return 参数键值
     */
    public String getByKey(String configKey) {
        return configService.selectConfigByKey(configKey);
    }
}
