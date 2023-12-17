package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import com.github.pagehelper.util.StringUtil;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

   @Resource
   UserService userService;

   //新增用户信息
  @PostMapping("/add")
    public Result add(@RequestBody User user) {
      try {
          userService.save(user);
      } catch (Exception e) {
          if (e instanceof DuplicateKeyException) {
              return Result.error("插入数据失败");
          }else{
              return Result.error("系统错误");
          }
          }
          return Result.success();
      }
    /**
     * 修改用户信息
     */
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }
    /**
     * 删除用户信息
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.removeById(id);
        return Result.success();

    }

    /**
     * 查询全部用户信息
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
       List<User> userList=userService.list(new QueryWrapper<User>().orderByDesc("id"));
        return Result.success(userList);
    }
    /**
     * 根据ID查询用户信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }
    //批量删除
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        userService.removeBatchByIds(ids);
        return Result.success();
    }
    //分页查询
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String username,String name){
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>().orderByDesc("id");
        queryWrapper.like(StringUtil.isNotEmpty(username),"username",username);
        queryWrapper.like(StringUtil.isNotEmpty(name),"name",name);
        Page<User> page=userService.page(new Page<>(pageNum,pageSize),queryWrapper);
        return Result.success(page);

    }

  }
