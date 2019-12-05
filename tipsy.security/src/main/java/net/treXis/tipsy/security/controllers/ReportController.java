//package net.treXis.tipsy.security.controllers;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
////@EnableOAuth2Sso   //this is deprecated and it won't even register here
//public class ReportController {
//
//    @RequestMapping("/")
//    public String loadHome() {
//        return "home";
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/login**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//    }
//}
