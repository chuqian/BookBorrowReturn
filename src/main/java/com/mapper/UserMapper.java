package com.mapper;

import com.entity.Administrator;
import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author chuqian
 * @Date created in 2019/3/5 13:41
 * @describe
 */
@Repository
public interface UserMapper extends JpaRepository<User, Long> {

    public User findByUsernameAndPassword(String username, String password);

    public int deleteByUser_id(Long user_id);

}
