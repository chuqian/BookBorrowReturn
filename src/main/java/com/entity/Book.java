package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author chuqian
 * @Date created in 2019/1/3 21:07
 * @describe  馆藏图书
 */
@Entity
@Table(name = "t_book")
public class Book extends BaseEntity {
    private static final long serialVersionUID = 817340317649478923L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_BOOK", allocationSize = 1)
    private Long book_id;

    private Long bookdetail_id;    //图书详情编号

    private String ISBN;            //ISBN号

    private Integer isBorrowed = 0;  //是否已被借 1：是；0：否

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date in_date = new Date();          //入馆时间

    private Integer del = 0;        //是否删除  1：是；0：否

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getBook_detail_id() {
        return bookdetail_id;
    }

    public void setBook_detail_id(Long book_detail_id) {
        this.bookdetail_id = book_detail_id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(Integer isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
