package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.Doctor;
import com.example.springboot.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends ServiceImpl<DoctorMapper, Doctor> {
}
