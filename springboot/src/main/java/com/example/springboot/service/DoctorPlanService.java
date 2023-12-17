package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.DoctorPlan;
import com.example.springboot.mapper.DoctorPlanMapper;
import org.springframework.stereotype.Service;

@Service
public class DoctorPlanService  extends ServiceImpl<DoctorPlanMapper, DoctorPlan> {
}
