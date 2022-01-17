package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("booklist")
@Data
public class Booklist {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String type;
    private String press;
    private BigDecimal presstime;
}
