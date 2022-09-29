package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AndroidDevelopers on 2022/9/28.
 */
@RestController
public class UserController {
    final Logger logger;

    public UserController() {
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 更新计数，自增或者清零
     * @return API response json
     */
    @PostMapping(value = "/api/bind")
    ApiResponse create(@RequestBody UserRequest request) {
        logger.info("收到绑定用户请求" + request.toString());
        return ApiResponse.ok(request);}
}
