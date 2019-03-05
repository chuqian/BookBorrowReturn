package com.service;

import com.entity.Config;

/**
 * @Author chuqian
 * @Date created in 2019/2/21 22:23
 * @describe
 */
public interface ConfigService {

    /**
     * 根据键名查询参数配置信息
     * @param configKey 参数配置key
     * @return 参数键值
     */
    public String selectConfigByKey(String configKey);
}
