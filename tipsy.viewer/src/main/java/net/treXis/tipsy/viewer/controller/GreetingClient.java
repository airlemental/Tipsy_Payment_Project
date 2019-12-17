package net.treXis.tipsy.viewer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("spring-cloud-eureka-viewer")
public interface GreetingClient {

//    @RequestMapping("/greeting")
//    String greeting();

    @GetMapping("/api/greeting")
    String greeting();

}
