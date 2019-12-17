package net.treXis.tipsy.experience.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "spring-cloud-eureka-viewer")
public interface GreetingController {

    @RequestMapping("/greeting")
    String greeting();
}
