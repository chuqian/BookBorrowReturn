package com.entity;

import com.framework.aspectj.annotation.Excel;

import javax.persistence.*;

/**
 * @Author chuqian
 * @Date created in 2019/2/20 23:15
 * @describe 参数配置
 */
@Entity
@Table(name = "t_config")
public class Config extends BaseEntity {
    private static final long serialVersionUID = -3111933381393726671L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_CONFIG", allocationSize = 1)
    private Long config_id;

    @Excel(name = "参数名称")
    private String config_name;  //参数名称

    @Excel(name = "参数键名")
    private String config_key;  //参数键名

    @Excel(name = "参数键值")
    private String config_value;  //参数键值

    @Excel(name = "系统内置", readConverterExp = "Y=是,N=否")
    private String config_type;  //系统内置（Y是 N否）

    public Config(Long config_id) {
        this.config_id = config_id;
    }

    public Config(String config_key) {
        this.config_key = config_key;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getConfig_id() {
        return config_id;
    }

    public void setConfig_id(Long config_id) {
        this.config_id = config_id;
    }

    public String getConfig_name() {
        return config_name;
    }

    public void setConfig_name(String config_name) {
        this.config_name = config_name;
    }

    public String getConfig_key() {
        return config_key;
    }

    public void setConfig_key(String config_key) {
        this.config_key = config_key;
    }

    public String getConfig_value() {
        return config_value;
    }

    public void setConfig_value(String config_value) {
        this.config_value = config_value;
    }

    public String getConfig_type() {
        return config_type;
    }

    public void setConfig_type(String config_type) {
        this.config_type = config_type;
    }
}
