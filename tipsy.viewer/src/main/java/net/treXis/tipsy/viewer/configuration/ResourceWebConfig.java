package net.treXis.tipsy.viewer.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({"net.treXis.tipsy.viewer"})  //{"net.treXis.tipsy.viewer.configuration", "net.treXis.tipsy.viewer.controller"}
public class ResourceWebConfig implements WebMvcConfigurer {

}
