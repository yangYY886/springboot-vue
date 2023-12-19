package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("appointment")
public class Appointment {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String weeks;
    private String doctor;
    private String depart;
    private String username;
    private String name;
    private Integer age;
    private String sex;
    private String phone;
    private String email;
    private String cases;
    private String status;
    private String reason;

}
