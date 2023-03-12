package org.exam.test.api;

import annotation.PermissionValidation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

@Controller
@RequestMapping(value = "/root")
@Slf4j
public class HelloWorldController {


    @GetMapping(value = "/hello")
    @ResponseBody
    @PermissionValidation(name="tea", permissions = {"ZZZZ","TTTT"})
    public Map<String, Object> showHelloWorld() {
        Map<String,Object> map = new HashMap<>();
        map.put("key","value");
        return map;
    }

    @PostMapping(value = "/test")
    @ResponseBody
    public Map<String, Object> test(@RequestBody List<Map<String, Object>> param) throws IOException {
        List<Map<String, Object>> list = param;

        LoggerFactory.getLogger(HelloWorldController.class).info("data:{}", JSON.toJSONString(list));

        LockSupport.parkNanos(100);
        return list.get(0);
    }

}
