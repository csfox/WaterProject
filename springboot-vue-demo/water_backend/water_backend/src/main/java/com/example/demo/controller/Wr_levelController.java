package com.example.demo.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.Wr_level;
import com.example.demo.mapper.Wr_levelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/wr_level")
public class Wr_levelController {
    @Resource
    Wr_levelMapper wr_levelMapper;

    @GetMapping
    public Result<?> List(){
        QueryWrapper<Wr_level> wrapper = new QueryWrapper<>();
        wrapper.select("level_id","waterLevel");
        List<Wr_level> wr_levels = wr_levelMapper.selectList(wrapper);
        return Result.success(wr_levels.get(wr_levels.size()-1));
    }

}
