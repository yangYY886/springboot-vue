package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class News {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private   String title;
    private   String description;
    private   String content;
    private   String time;
}
