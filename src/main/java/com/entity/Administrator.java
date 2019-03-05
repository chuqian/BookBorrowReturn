package com.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author chuqian
 * @Date created in 2019/3/5 13:33
 * @describe 管理员
 */
@Entity
@Table(name = "t_administrator")
public class Administrator extends BaseEntity {

    private static final long serialVersionUID = 1037488192630378423L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_ADMINISTRATOR", allocationSize = 1)
    private Long sys_id;

    private String sys_name;

    private String sys_password;

    /**
     * 性别 1：男，0：女
     */
    private Integer sys_sex;

    private Date sys_createTime;

    public Long getSys_id() {
        return sys_id;
    }

    public void setSys_id(Long sys_id) {
        this.sys_id = sys_id;
    }

    public String getSys_name() {
        return sys_name;
    }

    public void setSys_name(String sys_name) {
        this.sys_name = sys_name;
    }

    public String getSys_password() {
        return sys_password;
    }

    public void setSys_password(String sys_password) {
        this.sys_password = sys_password;
    }

    public Integer getSys_sex() {
        return sys_sex;
    }

    public void setSys_sex(Integer sys_sex) {
        this.sys_sex = sys_sex;
    }

    public Date getSys_createTime() {
        return sys_createTime;
    }

    public void setSys_createTime(Date sys_createTime) {
        this.sys_createTime = sys_createTime;
    }
}
