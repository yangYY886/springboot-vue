package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   UserService userService;

   //新增用户信息
  @PostMapping("/add")
    public Result add(@RequestBody User user) {
      try {
          userService.insertUser(user);
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
        userService.updateUser(user);
        return Result.success();
    }
    /**
     * 删除用户信息
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.deleteUser(id);
        return Result.success();

    }

    /**
     * 查询全部用户信息
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
       List<User> userList=userService.selectAll();
        return Result.success(userList);
    }
    /**
     * 根据ID查询用户信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        User user = userService.selectById(id);
        return Result.success(user);
    }
    /**
     * 根据name查询用户信息
     */
    @GetMapping("/selectByName/{name}")
    public Result selectByName(@PathVariable String name) {
        List<User> userList = userService.selectByName(name);
        return Result.success(userList);
    }

    /**
     * 多条件查询用户信息
     */
    @GetMapping("/selectByMore")
    public Result selectByMore(@RequestParam String username,@RequestParam String name) {
        List<User> userList = userService.selectByMore(username,name);
        return Result.success(userList);
    }
    /**
     * 多条件的模糊查询用户信息
     */
    @GetMapping("/selectByMo")
    public Result selectByMo(@RequestParam String username,@RequestParam String name) {
        List<User> userList = userService.selectByMo(username,name);
        return Result.success(userList);
    }

  }
