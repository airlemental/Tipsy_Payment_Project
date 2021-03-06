package net.treXis.tipsy.viewer.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@FeignClient("feign-greeting")
public interface GreetingClient {

    @RequestMapping("/greeting")
    String greeting();

//    @GetMapping("/api/greeting")
//    String greeting();

}
