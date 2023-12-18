package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.News;
import com.example.springboot.service.NewsService;
import com.github.pagehelper.util.StringUtil;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/News")
public class NewsController {
    @Resource
    NewsService newsService;
    @PostMapping("/add")
    public Result add(@RequestBody News news) {
        try {
            newsService.save(news);
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
    public Result update(@RequestBody News news) {
        newsService.updateById(news);
        return Result.success();
    }
    /**
     * 删除用户信息
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        newsService.removeById(id);
        return Result.success();

    }

    /**
     * 查询全部用户信息
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<News> userList=newsService.list(new QueryWrapper<News>().orderByDesc("id"));
        return Result.success(userList);
    }
    /**
     * 根据ID查询用户信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        News news = newsService.getById(id);
        return Result.success(news);
    }
    //批量删除
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        newsService.removeBatchByIds(ids);
        return Result.success();
    }
    //分页查询
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam Integer pageNum ,Integer pageSize,@RequestParam String title){
        QueryWrapper<News> queryWrapper=new QueryWrapper<News>().orderByDesc("id");
        queryWrapper.like(StringUtil.isNotEmpty(title),"username",title);
        Page<News> page=newsService.page(new Page<>(pageNum,pageSize),queryWrapper);
        return Result.success(page);

    }

}
