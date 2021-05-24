package com.liuxuhuang.community.controller;

import com.liuxuhuang.community.entity.Visit;
import com.liuxuhuang.community.service.VisitService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Visit)表控制层
 *
 * @author liuxuhuang
 * @since 2021-05-19 20:17:31
 */
@Api(tags = "visit")
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
    @GetMapping("selectById/{id}")
    @ApiOperation("根据id查询访客")
    @ApiImplicitParam(value = "id", name = "id", dataType = "int", required = true)
    @ResponseBody
    public Map<String, Object> selectOne(@PathVariable("id") int id) {
        Map<String, Object> map = new HashMap<>();
        Visit visit = this.visitService.queryById(id);
        if (visit != null && !visit.equals("")) {
            map.put("code", 200);
            map.put("message", "成功根据id查询到数据");
            map.put("success", true);
            map.put("data", visit);
        } else {
            map.put("code", 404);
            map.put("message", "根据id查询数据失败");
            map.put("success", false);
            map.put("data", null);
        }
        return map;
    }

    @ApiOperation(value = "根据名称查询数据")
    @ResponseBody
    @ApiImplicitParam(name = "visitorName", value = "visitorName", required = true, dataType = "string")
    @GetMapping(value = "selectByName/{visitorName}")
    public Map<String, Object> selectByName(@PathVariable("visitorName") String visitorName) {
        Map<String, Object> map = new HashMap<>();
        Visit visit = null;
        visit = this.visitService.queryByName(visitorName);
        if (visit != null && !visit.equals("")) {
            map.put("code", 200);
            map.put("message", "根据名称查询数据成功");
            map.put("success", true);
            map.put("data", visit);
        } else {
            map.put("code", 404);
            map.put("message", "根据名称查询数据失败");
            map.put("success", false);
            map.put("data", null);
        }
        return map;
    }

    /**
     * 增加访客
     *
     * @return
     */
    @ApiOperation(value = "添加访客")
    @ApiParam(value = "visit", name = "访客")
    @ResponseBody
    @PostMapping(value = "addVisit")
    public Map<String, Object> insertVisit(@RequestBody Visit visit) {
        boolean flay = false;
        Map<String, Object> map = new HashMap<>();
        flay = this.visitService.insert(visit);
        if (flay) {
            map.put("code", 200);
            map.put("message", "添加访客成功");
            map.put("success", true);
            map.put("data", null);
        } else {
            map.put("code", 404);
            map.put("message", "添加访客失败");
            map.put("success", false);
            map.put("data", null);
        }
        return map;
    }

    @ResponseBody
    @GetMapping(value = "queryAllByLimit/{offset}/{limit}")
    @ApiOperation("分页查询")
    @ApiImplicitParams({@ApiImplicitParam(value = "offset", name = "offset", dataType = "int", required = true), @ApiImplicitParam(value = "limit", name = "limit", dataType = "int", required = true)})
    public Map<String, Object> queryAllByLimit(@PathVariable("offset") int offset, @PathVariable("limit") int limit) {
        Map<String, Object> map = new HashMap<>();
        List<Visit> list = new ArrayList<>();
        list = this.visitService.queryAllByLimit(offset, limit);
        if (list != null && list.size() > 0) {
            map.put("code", 200);
            map.put("message", "分页查询成功");
            map.put("success", true);
            map.put("data", list);
        } else {
            map.put("code", 404);
            map.put("message", "分页查询失败");
            map.put("success", false);
            map.put("data", null);
        }
        return map;
    }

    /**
     * 修改访客信息
     *
     * @param visit
     * @return
     */
    @ApiOperation(value = "修改访客信息")
    @ResponseBody
    @PostMapping(value = "updateVisit")
    @ApiParam(value = "visit", name = "visit")
    public Map<String, Object> updateVisit(@RequestBody Visit visit) {
        boolean flag = false;
        Visit v = new Visit();
        v.setVisitReason(visit.getVisitReason().replace(" ", ""));
        v.setEnterTime(visit.getEnterTime());
        v.setLeaveTime(visit.getLeaveTime());
        v.setVisitorName(visit.getVisitorName().replace(" ", ""));
        Map<String, Object> map = new HashMap<>();
        flag = this.visitService.update(v);
        if (flag) {
            map.put("code", 200);
            map.put("message", "修改访客信息成功");
            map.put("success", true);
            map.put("data", null);
        } else {
            map.put("code", 404);
            map.put("message", "修改访客信息失败");
            map.put("success", false);
            map.put("data", null);
        }
        return map;
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "deleteById/{id}")
    @ApiOperation("根据id删除数据")
    @ApiImplicitParam(value = "id", name = "id", required = true, dataType = "int")
    public Map<String, Object> deleteById(@PathVariable("id") int id) {
        Map<String, Object> map = new HashMap<>();
        boolean flag = false;
        flag = this.visitService.deleteById(id);
        if (flag) {
            map.put("code", 200);
            map.put("message", "根据id删除数据成功");
            map.put("success", true);
            map.put("data", null);
        } else {
            map.put("code", 404);
            map.put("message", "根据id删除数据失败");
            map.put("success", false);
            map.put("data", null);
        }
        return map;
    }

    @ResponseBody
    @GetMapping(value = "deleteByName/{visitorName}")
    @ApiOperation("根据名称删除数据")
    @ApiImplicitParam(value = "visitorName", name = "visitorName", dataType = "string", required = true)
    public Map<String, Object> deleteByName(@PathVariable("visitorName") String visitorName) {
        Map<String, Object> map = new HashMap<>();
        boolean flag = false;
        flag = this.visitService.deleteByName(visitorName);
        if (flag) {
            map.put("code", 200);
            map.put("message", "根据名称删除数据成功");
            map.put("success", true);
            map.put("data", null);
        } else {
            map.put("code", 404);
            map.put("message", "根据名称删除数据失败");
            map.put("success", false);
            map.put("data", null);
        }
        return map;
    }
}
