package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author chuqian
 * @Date created in 2019/2/17 19:08
 * @describe 部门
 */
@Entity
@Table(name = "t_department")
public class Department implements Serializable {
    private static final long serialVersionUID = 8347533740514698006L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_DEPARTMENT", allocationSize = 1)
    private Long department_id;  //部门ID

    private Long parent_id;   //父部门ID

    private String ancestors;  // 祖级列表

    private String department_name;  //部门名称

    private String parent_name;  //父部门名称

    private String leader;     //负责人

    private String phone;    //联系电话

    private String email;   //邮箱

    private int status = 1;   //部门状态:1正常, 0停用

    private int del = 0;   //是否删除:1是， 0否

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }
}
