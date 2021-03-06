package com.liuxuhuang.community.dao;

import com.liuxuhuang.community.entity.Visit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Visit)表数据库访问层
 *
 * @author liuxuhuang
 * @since 2021-05-19 20:17:31
 */
@Repository
public interface VisitDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Visit queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Visit> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param visit 实例对象
     * @return 对象列表
     */
    List<Visit> queryAll(Visit visit);

    /**
     * 新增数据
     *
     * @param visit 实例对象
     * @return 影响行数
     */
    int insert(Visit visit);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Visit> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Visit> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Visit> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Visit> entities);

    /**
     * 修改数据
     *
     * @param visit 实例对象
     * @return 影响行数
     */
    int update(Visit visit);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);

    /**
     * 根据名称删除数据
     *
     * @param visitorName
     * @return
     */
    int deleteByName(String visitorName);

    /**
     * 根据名称查询数据
     *
     * @param visitorName
     * @return
     */
    Visit queryByName(String visitorName);
}

