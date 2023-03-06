package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@TableName("Wr_level")
@Data
public class Wr_level {
    @TableId(value = "level_id",type = IdType.AUTO)
    private Integer level_id;
    private Timestamp timestamp;
    private Double waterLevel;

}
