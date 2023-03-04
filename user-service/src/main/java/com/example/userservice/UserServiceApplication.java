package com.example.userservice;

import com.example.userservice.error.FeignErrorDecoder;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients /** 타 마이크로 서비스 호출을 위해 기술된 Annotation */
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



	/** RestTemplate으로 타 마이크로 서비스 호출을 위해 기술 */
	@Bean
	@LoadBalanced // native-file-repo의 user-service.yml 파일의 order_service.url 속성의 '127.0.0.0:8000' 내용을 Microservice명인 order-service로 기술을 가능하게 하는 Annotation.
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/** FeignClient Logging : FeignClient 호출시 관련 정보 로깅 */
	/*
	 * 물론 로깅 관련 설정은 application.yml 파일에 기술되어 있음.
	 */
	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

// @Component로 등록된 파일은 Starter파일에서 @Bean으로 기술할 필요 없음.
//	@Bean
//	public FeignErrorDecoder getFeignErrorDecoder() {
//		return new FeignErrorDecoder();
//	}






}
