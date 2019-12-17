package net.treXis.tipsy.viewer;

import net.treXis.tipsy.viewer.controller.GreetingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages = {"net.treXis.tipsy.viewer.controller", "net.treXis.tipsy.viewer", "net.treXis.tipsy.viewer.model", "net.treXis.tipsy.viewer.configuration"})
@EnableFeignClients
@EnableEurekaClient
public class ViewerApplication {

	@Autowired
	private GreetingClient greetingClient;

//	private final GreetingClient greetingClient;
//	@Autowired
//	public ViewerApplication(GreetingClient greetingClient) {
//		this.greetingClient = greetingClient;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ViewerApplication.class, args);
	}

	@RequestMapping("/api/get-greeting")
	public String greeting(Model model) {
		model.addAttribute("greeting", greetingClient.greeting());
		return "greeting-view";
	}

}

// Feign is a discovery aware Spring RestTemplate
// It uses interfaces to communicate with endpoints.
// The interfaces will be automatically implemented at runtime.
// It uses "service-names" instead of "service-urls".
// It tracks instances of services without manually scanning with application.getInstances().get();
// RestTemplate can also be used to access Eureka client-services by name.
// To enable: 	annotate a @Configuration with @EnableFeignClients
// 				annotate an interface with @FeignClient(“service-name”)
// 				@Autowire it into a controller
// create such Feign Clients is to create interfaces with @RequestMapping annotated methods and put them into a separate module
// To share between Server and Client:
//      Server-side, implement them as @Controller,
//      Client-side, extend, and annotate as @FeignClient.
// Dependency "spring-cloud-starter-eureka" needs to be included.
// @EnableEurekaClient on the main application class.
// To present a view, include: "spring-boot-starter-web" and "spring-boot-starter-thymeleaf"