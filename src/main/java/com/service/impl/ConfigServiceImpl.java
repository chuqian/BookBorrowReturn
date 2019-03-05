package com.service.impl;

import com.entity.Config;
import com.mapper.ConfigMapper;
import com.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chuqian
 * @Date created in 2019/2/21 22:30
 * @describe
 */
@Service
public class ConfigServiceImpl implements ConfigService {

   /* @Autowired
    private ConfigMapper configMapper;*/

    @Override
    public String selectConfigByKey(String configKey) {
       /* Config config = new Config(configKey);
        Config confResult = configMapper.selectConfig(config);
        return  confResult != null ? confResult.getConfig_value() : "";*/
       return "";
    }


}
