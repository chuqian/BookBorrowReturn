package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author chuqian
 * @Date created in 2019/1/3 20:37
 * @describe 用户实体
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 270884278928576807L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_USER", allocationSize = 1)
    private Long user_id;

    private Long dept_id;     //所属系别Id

    private String username;

    private String password;

    private Integer sex = 1;

    private String phone;         //手机号码

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date register_date = new Date();  //注册时间

    private Integer borrow_sum;  //累计借书次数

    private Integer del = 0;         //是否删除

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Integer getBorrow_sum() {
        return borrow_sum;
    }

    public void setBorrow_sum(Integer borrow_sum) {
        this.borrow_sum = borrow_sum;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public boolean isAdmin() {
        return isAdmin(this.user_id);
    }

    public static boolean isAdmin(Long user_id) {
        return user_id!=null && 1L==user_id;
    }
}
