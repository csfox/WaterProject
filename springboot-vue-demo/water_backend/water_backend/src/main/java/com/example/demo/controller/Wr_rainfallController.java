package com.example.demo.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.Wr_rainfall;
import com.example.demo.mapper.Wr_rainfallMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/wr_rainfall")
public class Wr_rainfallController {
    @Resource
    Wr_rainfallMapper wr_rainfallMapper;


    @GetMapping
    public Result<?> List(){
        QueryWrapper<Wr_rainfall> wrapper = new QueryWrapper<>();
        wrapper.select("rainfall_id","ao_out");
        List<Wr_rainfall> wr_rainfalls = wr_rainfallMapper.selectList(wrapper);
        for(Wr_rainfall wr_rainfall:wr_rainfalls) {
            System.out.println(wr_rainfall);
        }
        return Result.success(wr_rainfalls.get(wr_rainfalls.size()-1));
    }
}
