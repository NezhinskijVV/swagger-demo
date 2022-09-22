package ru.buttonone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
    public Map<String, Object> sayHello() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("results", 164);
        return map;
    }
}
