package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author chuqian
 * @Date created in 2019/1/3 21:12
 * @describe  图书详情
 */
@Entity
@Table(name = "t_book_detail")
public class BookDetail implements Serializable {
    private static final long serialVersionUID = -7968191619379984057L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_BOOK_DETAIL", allocationSize = 1)
    private Long book_detail_id;
    private String name;    //书名
    private Integer sum;   //馆藏总数
    private Integer remain; //剩余数
    private Integer del = 0;   //是否删除

    public Long getBookdetail_id() {
        return book_detail_id;
    }

    public void setBookdetail_id(Long bookdetail_id) {
        this.book_detail_id = bookdetail_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
