package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author chuqian
 * @Date created in 2019/1/3 21:53
 * @describe  用户当前已借图书
 */
@Entity
@Table(name = "t_user_borrowed")
public class UserBorrowed implements Serializable {
    private static final long serialVersionUID = -4856654290058277254L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_USER_BORROWED", allocationSize = 1)
    private Long user_borrowed_id;
    private Long user_id;    //用户ID
    private Long book_id;    //图书ID
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date borrow_date = new Date();    //借书时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date return_date;   //还书时间
    private Integer del = 0;      //是否删除

    public Long getUser_borrowed_id() {
        return user_borrowed_id;
    }

    public void setUser_borrowed_id(Long user_borrowed_id) {
        this.user_borrowed_id = user_borrowed_id;
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

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
