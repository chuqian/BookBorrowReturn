package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author chuqian
 * @Date created in 2019/2/23 11:20
 * @describe 专业系别
 */
@Entity
@Table(name = "t_dept")
public class Dept extends BaseEntity {
    private static final long serialVersionUID = -6771034070737269930L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_DEPT", allocationSize = 1)
    private Long dept_id;  //系别ID

    private String dept_name;  //系别名称

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;  //创建时间

    private String leader;     //负责人

    private String phone;    //联系电话

    private String email;   //邮箱

    private int status = 1;   //部门状态:1正常, 0停用

    private int del = 0;   //是否删除:1是， 0否

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
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
