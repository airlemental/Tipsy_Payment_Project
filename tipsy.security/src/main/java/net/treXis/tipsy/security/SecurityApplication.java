package net.treXis.tipsy.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"net.treXis.tipsy.security"})
@EnableEurekaClient
public class SecurityApplication extends SpringBootServletInitializer {

//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	FundRequestsRepository fundRequestsRepository;

//	@RequestMapping("/test")
//	public String home() {
//		return "Your test succeeded.";
//	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

//	@Override
//	public void run(String... args) {
//
//	}

}
