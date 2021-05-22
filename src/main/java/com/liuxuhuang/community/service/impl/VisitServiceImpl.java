package com.liuxuhuang.community.service.impl;

import com.liuxuhuang.community.entity.Visit;
import com.liuxuhuang.community.dao.VisitDao;
import com.liuxuhuang.community.service.VisitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Visit)表服务实现类
 *
 * @author liuxuhuang
 * @since 2021-05-19 20:17:31
 */
@Service("visitService")
public class VisitServiceImpl implements VisitService {
    @Resource
    private VisitDao visitDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Visit queryById(int id) {
        return this.visitDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Visit> queryAllByLimit(int offset, int limit) {
        return this.visitDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    @Override
    public Visit insert(Visit visit) {
        this.visitDao.insert(visit);
        return visit;
    }

    /**
     * 修改数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    @Override
    public Visit update(Visit visit) {
        this.visitDao.update(visit);
        return this.queryById(visit.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.visitDao.deleteById(id) > 0;
    }
}
