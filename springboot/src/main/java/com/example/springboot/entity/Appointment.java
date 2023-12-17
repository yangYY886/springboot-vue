package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("appointment")
public class Appointment {
    @TableId(type = IdType.AUTO)
    private Integer appointment_id;
    private Integer id;
    private Integer doctor_id;
    private Integer department_id;
    private String appointmentWeek;
    private String appointmentTime;
    private String status;
    private String operation;
}
