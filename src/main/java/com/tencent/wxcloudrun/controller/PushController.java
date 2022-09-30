package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.PushRequest;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by AndroidDevelopers on 2022/9/28.
 */
@RestController
public class PushController {
    final Logger logger;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public PushController() {
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    @PostMapping(value = "/api/push")
    ApiResponse push(@RequestBody PushRequest request) {
        String json = "{\n" +
                "  \"touser\":  \"oGugd0VzsmYtI5qXQdJlUJRPJvjA\",\n" +
                "  \"template_id\": \"6ov2ThTUvQyc-tjcbWf7RCqapWTkYyZfoisxURgPmrc\",\n" +
                "  \"page\": \"index/index\",\n" +
                "  \"miniprogram_state\":\"developer\",\n" +
                "  \"lang\":\"zh_CN\",\n" +
                "  \"data\": {\n" +
                "      \"thing1\": {\n" +
                "          \"value\": \"IEP-超级服务器\"\n" +
                "      },\n" +
                "      \"time2\": {\n" +
                "          \"value\": \"2021-09-10 19:00:00\"\n" +
                "      },\n" +
                "      \"thing3\": {\n" +
                "          \"value\": \"超级病毒入侵\"\n" +
                "      } ,\n" +
                "      \"thing4\": {\n" +
                "          \"value\": \"一级\"\n" +
                "      }\n" +
                "       \n" +
                "  }\n" +
                "}";
        OkHttpClient client = new OkHttpClient();
        okhttp3.RequestBody body = okhttp3.RequestBody.create(JSON,json );
        Request req = new Request.Builder()
                .url("https://api.weixin.qq.com/cgi-bin/message/subscribe/send")
                .post(body)
                .build();
        try {
            Response response = client.newCall(req).execute();
            return ApiResponse.ok(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            return ApiResponse.error(e.getLocalizedMessage());
        }

    }
}
