package com.liuxuhuang.community.controller;

import com.liuxuhuang.community.entity.Visit;
import com.liuxuhuang.community.service.VisitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Visit)表控制层
 *
 * @author liuxuhuang
 * @since 2021-05-19 20:17:31
 */
@RestController
@RequestMapping("visit")
public class VisitController {
    /**
     * 服务对象
     */
    @Resource
    private VisitService visitService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Visit selectOne(int id) {
        return this.visitService.queryById(id);
    }

}
