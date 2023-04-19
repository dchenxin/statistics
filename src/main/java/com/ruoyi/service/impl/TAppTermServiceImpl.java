package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.TAppTermMapper;
import com.ruoyi.domain.TAppTerm;
import com.ruoyi.service.ITAppTermService;

/**
 * 应用条款管理Service业务层处理
 *
 * @author gl
 * @date 2020-11-11
 */
@Service
public class TAppTermServiceImpl extends ServiceImpl<TAppTermMapper, TAppTerm> implements ITAppTermService {
    @Autowired
    private TAppTermMapper tAppTermMapper;

}
