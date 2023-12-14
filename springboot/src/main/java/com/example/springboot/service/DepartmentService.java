package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.Appointment;
import com.example.springboot.entity.Department;
import com.example.springboot.mapper.AppointmentMapper;
import com.example.springboot.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> {
}
