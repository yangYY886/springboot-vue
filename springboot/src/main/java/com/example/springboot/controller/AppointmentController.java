package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Appointment;
import com.example.springboot.entity.User;
import com.example.springboot.service.AppointmentService;
import com.github.pagehelper.util.StringUtil;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
    @Resource
    AppointmentService appointmentService;
    @PostMapping("/add")
    public Result add(@RequestBody Appointment appointment) {
        try {
            appointmentService.save(appointment);
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
    public Result update(@RequestBody Appointment appointment) {
        appointmentService.updateById(appointment);
        return Result.success();
    }
    /**
     * 删除用户信息
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        appointmentService.removeById(id);
        return Result.success();

    }

    /**
     * 查询全部用户信息
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Appointment> userList=appointmentService.list(new QueryWrapper<Appointment>().orderByDesc("id"));
        return Result.success(userList);
    }
    /**
     * 根据ID查询用户信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Appointment appointment = appointmentService.getById(id);
        return Result.success(appointment);
    }
    //批量删除
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        appointmentService.removeBatchByIds(ids);
        return Result.success();
    }
    //分页查询
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String username,String name){
        QueryWrapper<Appointment> queryWrapper=new QueryWrapper<Appointment>().orderByDesc("id");
        queryWrapper.like(StringUtil.isNotEmpty(username),"username",username);
        queryWrapper.like(StringUtil.isNotEmpty(name),"name",name);
        Page<Appointment> page=appointmentService.page(new Page<>(pageNum,pageSize),queryWrapper);
        return Result.success(page);

    }
}
