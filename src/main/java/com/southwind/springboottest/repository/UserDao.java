package com.southwind.springboottest.repository;

import com.southwind.springboottest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author larry
 * @date 2020/8/6 9:26
 * @creed: Talk is cheap, show me the code!
 */
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String name, String pwd);

    User findByUsername(String name);

}
