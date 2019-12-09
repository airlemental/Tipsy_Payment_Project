package net.treXis.tipsy.security;

import net.treXis.tipsy.security.repository.FundRequestsJpaRepository;
import net.treXis.tipsy.security.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages = {"net.treXis.tipsy"})
@EnableEurekaClient
public class SecurityApplication extends SpringBootServletInitializer {

	@Autowired
	UserJpaRepository userJpaRepository;

	@Autowired
	FundRequestsJpaRepository fundRequestsJpaRepository;


	@RequestMapping("/test")
	public String home() {
		return "Your test succeeded.";
	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

//	@Override
//	public void run(String... args) {
//
//	}

}
