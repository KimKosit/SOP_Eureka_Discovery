package sop.service.discoveryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryClientApplication {
	@Autowired
	private ServiceDiscoveryClient serviceDiscoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryClientApplication.class, args);
	}
}
