package com.example.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor  //全类型的所有属性的构造函数
@NoArgsConstructor   //创建无参构造函数
@Builder
public class Result{
    private static final String SUCCESS ="0";
    private static final String ERROR ="0";
    private String code;
    private String msg;
    private Object data;
    public static  Result success(){
        Result result =new Result();
        result.setCode(SUCCESS);
        return result;
    }
    public static  Result success(Object data){
        Result result =new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }
    public static  Result error(String msg){
        Result result =new Result();
        result.setCode(ERROR);
        result.setMsg(msg);
        return result;
    }
}
