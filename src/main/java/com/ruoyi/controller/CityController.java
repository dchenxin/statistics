package com.ruoyi.controller;

import com.ruoyi.domain.City;
import com.ruoyi.service.impl.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api")
public class CityController {

    private final CityService cityService;
    @GetMapping("/query")
    public List<City> query(){
        return cityService.queryAll();
    }

    @PostMapping("/add")
    public int add(@RequestBody City city){
        return cityService.add(city);
    }

    @PostMapping("/update")
    public int update(@RequestBody City city){
        return cityService.update(city);
    }

    @GetMapping("/delete")
    public int delete(String id){
        return cityService.deleteById(id);
    }
}
