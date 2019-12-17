package net.treXis.tipsy.experience;

import com.netflix.discovery.EurekaClient;
import net.treXis.tipsy.experience.controller.GreetingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"net.treXis.tipsy.experience", "net.treXis.tipsy.experience.controller", "net.treXis.tipsy.experience.service"})
@RestController
public class ExperienceApplication implements GreetingController {

	@Qualifier("eurekaClient")
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(ExperienceApplication.class, args);
	}

	@Override
	public String greeting(){
		return String.format("The application '%s' has been Discovered! ", eurekaClient.getApplication(appName).getName());
	}


}
