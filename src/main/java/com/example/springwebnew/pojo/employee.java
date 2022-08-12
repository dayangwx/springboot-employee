package com.example.springwebnew.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("emp")
public class employee {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String email;

    @DateTimeFormat(pattern = "yyyy-M-dd")
    private Date birth;

    private Integer gender;

    @TableField("deptId")
    private Integer deptId;

    public employee(Integer id,String name, String email, Integer gender, Integer deptId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.deptId = deptId;
        this.birth = new Date();
    }


    public employee() {
    }
}
