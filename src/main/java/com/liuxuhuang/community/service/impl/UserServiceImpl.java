package com.liuxuhuang.community.service.impl;

import com.liuxuhuang.community.dao.UserDao;
import com.liuxuhuang.community.entity.User;
import com.liuxuhuang.community.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User表)服务实现类
 *
 * @author liuxuhuang
 * @since 2021-05-19 18:48:17
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User selectById(int userId) {
        return this.userDao.selectById(userId);
    }

    @Override
    public User login(User user) {
        return this.userDao.login(user);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> selectPage(int start, int limit) {
        return this.userDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<User> selectAll() {
        return this.userDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<User> selectList(User user) {
        return this.userDao.selectList(user);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(User user) {
        return this.userDao.insert(user);
    }

    /**
     * 批量新增
     *
     * @param users 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<User> users) {
        return this.userDao.batchInsert(users);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int update(User user) {
        return this.userDao.update(user);
//        retun this.selectById(user.getUserId());
    }

    @Override
    public int deleteByName(String userName) {
        return this.userDao.deleteByName(userName);
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(int userId) {
        return this.userDao.deleteById(userId);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.userDao.count();
    }
}

