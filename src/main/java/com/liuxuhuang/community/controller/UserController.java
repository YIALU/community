package com.liuxuhuang.community.controller;

import com.liuxuhuang.community.entity.User;
import com.liuxuhuang.community.service.UserService;
import com.liuxuhuang.community.util.CreateName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * (User)控制层
 *
 * @author liuxuhuang
 * @since 2021-05-19 18:48:14
 */
@RestController
@RequestMapping("/user")
@Api(value = "user用户接口")
@CrossOrigin
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    Map<String, Object> map = new HashMap<>();

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @ApiParam(value = "user", name = "user")
    @ApiOperation(value = "登录接口")
    @PostMapping(value = "login")
    @ResponseBody
    public Map<String, Object> selectOne(@RequestBody User u) {
        String phone = u.getUserTel().replace(" ", "");
        String pwd = u.getPassword().replace(" ", "");
        User user1 = new User();
        user1.setUserTel(phone);
        user1.setPassword(pwd);
        User user = null;
        user = userService.login(user1);
        System.out.println("user=" + user);
        if (user.getToken() == null || user.getToken().equals("null") || user.equals("null") || user == null) {
            map.put("code", 201);
            map.put("message", "登录失败");
            map.put("success", false);
            map.put("data", null);
        } else {
            map.put("code", 200);
            map.put("message", "登录成功");
            map.put("success", true);
            map.put("data", user.getToken());
            map.put("type", user.getUserType());
        }
        return map;
    }

    /**
     * 新增一条数据
     *
     * @param user 实体类
     * @return Response对象
     */
    @ApiOperation("注册接口")
    @ApiParam(value = "user", name = "user")
    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody User user) {
        if (user.getUserType() == null || user.getUserType().equals("")) {
            user.setUserType("业主");
        }
        if (user.getUserName() == null || user.getUserName().equals("")) {
            CreateName createName = new CreateName();
            user.setUserName(createName.getUserName(10));
        }
        user.setRegisterTime(new Date());
        user.setToken(UUID.randomUUID().toString().replace("-", ""));
        int result = userService.insert(user);
        if (result > 0) {
            map.put("code", 200);
            map.put("message", "注册成功");
            map.put("success", true);
            map.put("data", null);
        } else {
            map.put("code", 201);
            map.put("message", "注册失败");
            map.put("success", true);
            map.put("data", null);
        }
        return map;
    }

    /**
     * 修改一条数据
     *
     * @param user 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiParam(value = "user", name = "user")
    @ApiOperation("更新个人信息")
    public Map<String, Object> update(@RequestBody User user) {
        int result = userService.update(user);
        if (result > 0) {
            map.put("code", 200);
            map.put("success", true);
            map.put("message", "修改成功");
            map.put("data", null);
        } else {
            map.put("code", 201);
            map.put("success", false);
            map.put("message", "修改失败");
            map.put("data", null);
        }
        return map;
    }

    /**
     * 删除一条数据
     *
     * @param id 参数对象
     * @return Response对象
     */
    @ApiOperation("根据id删除用户")
    @ApiParam(value = "userId", name = "userId", required = true)
    @RequestMapping(value = "deleteById", method = RequestMethod.DELETE)
    public Map<String, Object> deleteById(@PathVariable("userId") int id) {
        int result = userService.deleteById(id);
        if (result > 0) {
            map.put("code", 200);
            map.put("success", true);
            map.put("message", "删除成功");
            map.put("data", null);
        } else {
            map.put("code", 201);
            map.put("success", false);
            map.put("message", "删除失败");
            map.put("data", null);
        }
        return map;
    }

    /**
     * 根据用户名删除数据
     *
     * @param username
     * @return
     */
    @ApiParam(value = "userName", name = "userName", required = true, type = "string")
    @ApiOperation("根据用户名删除数据")
    @RequestMapping(value = "deleteByUserName", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteByUserName(@PathVariable("userName") String username) {
        int result = userService.deleteByName(username);
        if (result > 0) {
            map.put("code", 200);
            map.put("success", true);
            map.put("message", "删除成功");
            map.put("data", null);
        } else {
            map.put("code", 201);
            map.put("success", false);
            map.put("message", "删除失败");
            map.put("data", null);
        }
        return map;
    }

    /**
     * 查询全部
     *
     * @return Response对象
     */
    @ApiOperation("查询全部用户信息")
    @RequestMapping(value = "selectAll", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> selectAll() {
        List<User> users = userService.selectAll();
        if (users.size() > 0) {
            map.put("code", 200);
            map.put("success", true);
            map.put("message", "查询成功");
            map.put("data", users);
        } else {
            map.put("code", 201);
            map.put("success", false);
            map.put("message", "查询失败");
            map.put("data", null);
        }
        return map;
    }

    /**
     * 分页查询
     *
     * @param start 偏移
     * @param limit 条数
     * @return Response对象
     */
    @ApiOperation("分页查询")
    @ResponseBody
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    public Map<String, Object> selectPage(Integer start, Integer limit) {
        List<User> users = userService.selectPage(start, limit);
        if (users.size() > 0) {
            map.put("code", 200);
            map.put("success", true);
            map.put("message", "查询成功");
            map.put("data", users);
        } else {
            map.put("code", 201);
            map.put("success", false);
            map.put("message", "查询失败");
            map.put("data", null);
        }
        return map;
    }

}
