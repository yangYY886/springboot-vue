package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("dotorplan")
public class DoctorPlan {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String week;
    private String doctorName;
    private String department;
}
