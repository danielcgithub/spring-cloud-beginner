package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Configuration
	static class MyConfig {
		@Bean
		@LoadBalanced // this is from ribbon - load balances on the client side
		public RestTemplate rest() {
			return new RestTemplateBuilder().build();
		}

		@Bean
		public Sampler getSampler() {
			// sends everything no matter what off to zipkin
			// can implement other types of beans of type sampler, that are more selective
			// of what it sends to zipkin
			// AlwaysSampler is provided by sleuth
			return new AlwaysSampler();
		}
	}

}
