package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentMapper extends BaseMapper<Appointment> {
}
