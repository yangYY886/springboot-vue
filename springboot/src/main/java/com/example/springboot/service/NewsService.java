package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.News;
import com.example.springboot.mapper.NewsMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class NewsService extends ServiceImpl<NewsMapper, News> {
    @Resource NewsMapper newsMapper;
}
