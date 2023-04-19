package com.ruoyi.api;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"登录相关"})
@RestController
public class LoginApi {

    /*@ApiOperation("")
    @PostMapping("/encode")
    public AjaxResult encode(){
        SecurityUtils.encryptPassword()
    }*/
}
