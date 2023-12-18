package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Doctor;
import com.example.springboot.service.DoctorService;
import com.github.pagehelper.util.StringUtil;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Doctor")
public class DoctorController {
    @Resource
    DoctorService doctorService;
    @PostMapping("/add")
    public Result add(@RequestBody Doctor doctor) {
        try {
            doctorService.save(doctor);
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
    public Result update(@RequestBody Doctor doctor) {
        doctorService.updateById(doctor);
        return Result.success();
    }
    /**
     * 删除用户信息
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        doctorService.removeById(id);
        return Result.success();

    }

    /**
     * 查询全部用户信息
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Doctor> doctorList=doctorService.list(new QueryWrapper<Doctor>().orderByDesc("id"));
        return Result.success(doctorList);
    }
    /**
     * 根据ID查询用户信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Doctor user = doctorService.getById(id);
        return Result.success(user);
    }
    //批量删除
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        doctorService.removeBatchByIds(ids);
        return Result.success();
    }
    //分页查询
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String username,String name){
        QueryWrapper<Doctor> queryWrapper=new QueryWrapper<Doctor>().orderByDesc("id");
        queryWrapper.like(StringUtil.isNotEmpty(username),"username",username);
        queryWrapper.like(StringUtil.isNotEmpty(name),"name",name);
        Page<Doctor> page=doctorService.page(new Page<>(pageNum,pageSize),queryWrapper);
        return Result.success(page);

    }
    @GetMapping("/selectByPageL")
    public Result selectByPageL(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String depart,String week){
        QueryWrapper<Doctor> queryWrapperL=new QueryWrapper<Doctor>().orderByDesc("id");
        queryWrapperL.like(StringUtil.isNotEmpty(depart),"depart",depart);
        queryWrapperL.like(StringUtil.isNotEmpty(week),"week",week);
        Page<Doctor> page=doctorService.page(new Page<>(pageNum,pageSize),queryWrapperL);
        return Result.success(page);

    }
}
