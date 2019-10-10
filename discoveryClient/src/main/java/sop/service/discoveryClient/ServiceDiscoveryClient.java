package sop.service.discoveryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RestController
public class ServiceDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String getStudent(String studentId){
        RestTemplate restTemplate = new RestTemplate(); List<ServiceInstance> instances =
                discoveryClient.getInstances("studentservice");
                String serviceUri = String.format("%s/student" ,instances.get(0).getUri().toString(), studentId);
        ResponseEntity<String> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
        return restExchange.getBody();
    };
}
