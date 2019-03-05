package com.mapper;

import com.entity.Config;

/**
 * @Author chuqian
 * @Date created in 2019/2/21 22:43
 * @describe 参数配置 数据层
 */
public interface ConfigMapper {

    /**
     * 查询参数配置信息
     * @param config 参数配置
     * @return 参数配置信息
     */
    public Config selectConfig(Config config);
}
