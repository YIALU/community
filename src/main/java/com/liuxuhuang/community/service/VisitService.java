package com.liuxuhuang.community.service;

import com.liuxuhuang.community.entity.Visit;

import java.util.List;

/**
 * (Visit)表服务接口
 *
 * @author liuxuhuang
 * @since 2021-05-19 20:17:31
 */
public interface VisitService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Visit queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Visit> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    boolean insert(Visit visit);

    /**
     * 修改数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    boolean update(Visit visit);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);

    /**
     * 通过名称删除数据
     *
     * @param visitorName
     * @return
     */
    boolean deleteByName(String visitorName);

    /**
     * 根据名称查询数据
     *
     * @param visitorName
     * @return
     */
    Visit queryByName(String visitorName);
}
