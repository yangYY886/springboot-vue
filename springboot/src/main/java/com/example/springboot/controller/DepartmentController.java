package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Department;
import com.example.springboot.service.DepartmentService;
import com.github.pagehelper.util.StringUtil;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Data
@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Resource
    DepartmentService departmentService;
    @PostMapping("/departmentAdd")
    public Result departmentAdd(@RequestBody Department department) {
        try {
            departmentService.save(department);
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
    @PutMapping("/departmentUpdate")
    public Result departmentUpdate(@RequestBody Department department) {
        departmentService.updateById(department);
        return Result.success();
    }
    /**
     * 删除用户信息
     */
    @DeleteMapping("/departmentDelete/{department_id}")
    public Result departmentDelete(@PathVariable Integer department_id) {
        departmentService.removeById(department_id);
        return Result.success();

    }

    /**
     * 查询全部用户信息
     */
    @GetMapping("/departmentSelectAll")
    public Result doctorSelectAll() {
        List<Department> departmentList=departmentService.list(new QueryWrapper<Department>().orderByDesc("department_id"));
        return Result.success(departmentList);
    }
    /**
     * 根据ID查询用户信息
     */
    @GetMapping("/departmentSelectById/{department_id}")
    public Result selectById(@PathVariable Integer department_id) {
        Department department = departmentService.getById(department_id);
        return Result.success(department);
    }
    //批量删除
    @DeleteMapping("/departmentDelete/batch")
    public Result delete(@RequestBody List<Integer> department_ids) {
        departmentService.removeBatchByIds(department_ids);
        return Result.success();
    }
    //分页查询
    @GetMapping("/departmentSelectByPage")
    public Result selectByPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String name){
        QueryWrapper< Department> queryWrapper=new QueryWrapper<Department>().orderByDesc("id");
        queryWrapper.like(StringUtil.isNotEmpty(name),"name",name);
        Page<Department> page=departmentService.page(new Page<>(pageNum,pageSize),queryWrapper);
        return Result.success(page);

    }
}
