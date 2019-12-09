package net.treXis.tipsy.security.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    // can inject the variable value from the custom property into the file
    @Value("${connection.success}")  // special syntax tells spring to go looking in the properties files.
    private String appConnection;

    @GetMapping
    @RequestMapping("/")  //services the root of the application
    public Map<String, String> getStatus(){  //uses Jackson to manage the data and return JSON payload
        Map<String, String> map = new HashMap<>();
        map.put("app-connection", appConnection);
        return map;

    }

}
