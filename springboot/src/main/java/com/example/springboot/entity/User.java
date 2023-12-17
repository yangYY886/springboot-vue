package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(type= IdType.AUTO)
private Integer id;
private String  username;
private String  password;
private String  name;
private String  phone;
private String  email;
private String  address;
private String  avatar;
private String  role;
}