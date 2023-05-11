package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@TableName("Wr_rainfall")
@Data
public class Wr_rainfall {
    @TableId(value = "rainfall_id",type = IdType.AUTO)
    private Integer rainfallId;
    private Timestamp rainfallTime;
    private Double aoOut;
    private Integer doOut;

}
