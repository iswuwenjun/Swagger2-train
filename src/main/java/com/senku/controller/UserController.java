package com.senku.controller;

import com.senku.common.Result;
import com.senku.pojo.TkUserPojo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Swagger2测试接口
 *
 * @Author wuwenjun
 * @Date 2021/2/18 18:07
 */
@RestController
@Slf4j
@Api(tags = "用户接口")
public class UserController {

    /**
     * 新增用户
     * @param user
     * @return
     */
    @ApiOperation(value = "新增用户")
    @PostMapping("/addUser")
    public Result addUser(@RequestBody TkUserPojo user) {
        log.info("user:{}", user);
        return Result.success(user);
    }

    /**
     * 根据用户名和年龄获取用户
     *
     * @param name
     * @param age
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "Integer", paramType = "query", required = true)
    })
    @GetMapping("/getUserByNameAndAge")
    public Result getUserByNameAndAge(String name, Integer age) {
        log.info("name:{}, age:{}", name, age);
        return Result.success(new TkUserPojo());
    }
}
