package com.jas.sjdemo.service;

import com.jas.sjdemo.dao.UserDao;
import com.jas.sjdemo.entity.User;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 15:36
 */
@Service
@Slf4j
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserDao userDao;

    public long addOne(User user) {
        this.userDao.addOne(user);
        return user.getUserId();
    }

    public User getOne(long id) {
        return userDao.getOneById(id);
    }

    /**
     * 测试跨库事务
     */
    @ShardingTransactionType(TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    public void testTransactional() {
        User user1 = new User(123, "988", 12);
        logger.info("user1已经插入");
        logger.info("user1已经插入");
        this.userDao.addOne(user1);
        User user2 = new User(124, "988", 12);
        this.userDao.addOne(user2);
        this.userDao.addOne(user2);
    }
}