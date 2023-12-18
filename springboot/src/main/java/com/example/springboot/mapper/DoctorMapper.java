package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {
    @Select("SELECT * FROM doctor d LEFT JOIN department dep ON d.department_id = dep.id WHERE d.id = #{doctorId}")
    Doctor selectDoctorWithDepartment(@Param("doctorId") Integer doctorId);

}
