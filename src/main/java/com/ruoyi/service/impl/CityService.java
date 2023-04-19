package com.ruoyi.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.domain.City;
import com.ruoyi.mapper.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityMapper cityMapper;

    /**
     * 查询所有
     * @return
     */
    public List<City> queryAll(){
        return cityMapper.selectList(Wrappers.lambdaQuery());
    }

    /**
     * 通过主键删除
     * @param id
     * @return
     */
    public int deleteById(String id){
     return cityMapper.deleteById(id);
    }

    /**
     * 新增
     * @param city
     * @return
     */
    public int add(City city){
        return cityMapper.insert(city);
    }

    /**
     * 修改
     * @param city
     * @return
     */
    public int update(City city){
        return cityMapper.updateById(city);
    }

    /**
     * 查询某个
     * @return
     */
    public City queryone(Long id){
        return cityMapper.selectById(id);
    }

}
