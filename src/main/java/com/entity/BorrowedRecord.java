package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author chuqian
 * @Date created in 2019/1/3 21:57
 * @describe 用户借书记录
 */
@Entity
@Table(name = "t_borrow_record")
public class BorrowedRecord implements Serializable {
    private static final long serialVersionUID = -5762413066400456784L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_BOOK_RECORD", allocationSize = 1)
    private Long borrowed_record_id;
    private Long user_id;  //用户ID
    private Long book_id;  //图书ID
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date borrow_date = new Date();    //借书时间
    private Integer is_return = 0;   //  是否已还 1:是 0:否
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date return_date;    //还书日期
    private Integer is_overdue = 0;  //还书是否超期
    private Integer del = 0;  //是否删除

    public Long getBorrowed_record_id() {
        return borrowed_record_id;
    }

    public void setBorrowed_record_id(Long borrowed_record_id) {
        this.borrowed_record_id = borrowed_record_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Integer getIs_return() {
        return is_return;
    }

    public void setIs_return(Integer is_return) {
        this.is_return = is_return;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Integer getIs_overdue() {
        return is_overdue;
    }

    public void setIs_overdue(Integer is_overdue) {
        this.is_overdue = is_overdue;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}