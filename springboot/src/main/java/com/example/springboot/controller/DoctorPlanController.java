package com.example.springboot.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.DoctorPlan;
import com.example.springboot.service.DoctorPlanService;
import com.github.pagehelper.util.StringUtil;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Plan")
public class DoctorPlanController {
    @Resource
    DoctorPlanService doctorPlanService;
    @PostMapping("/add")
    public Result add(@RequestBody DoctorPlan doctorPlan) {
        try {
            doctorPlanService.save(doctorPlan);
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
    public Result update(@RequestBody DoctorPlan doctorPlan) {
        doctorPlanService.updateById(doctorPlan);
        return Result.success();
    }
    /**
     * 删除用户信息
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        doctorPlanService.removeById(id);
        return Result.success();

    }

    /**
     * 查询全部用户信息
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<DoctorPlan> userList=doctorPlanService.list(new QueryWrapper<DoctorPlan>().orderByDesc("id"));
        return Result.success(userList);
    }
    /**
     * 根据ID查询用户信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        DoctorPlan doctorPlan = doctorPlanService.getById(id);
        return Result.success(doctorPlan);
    }
    //批量删除
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        doctorPlanService.removeBatchByIds(ids);
        return Result.success();
    }
    //分页查询
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String username,String name){
        QueryWrapper<DoctorPlan> queryWrapper=new QueryWrapper<DoctorPlan>().orderByDesc("id");
        queryWrapper.like(StringUtil.isNotEmpty(username),"username",username);
        queryWrapper.like(StringUtil.isNotEmpty(name),"name",name);
        Page<DoctorPlan> page=doctorPlanService.page(new Page<>(pageNum,pageSize),queryWrapper);
        return Result.success(page);
    }
}
