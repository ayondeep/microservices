package com.home.licensingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
// Tells the microservice that it is a protected resource. This annotation enforces a filter
// that intercepts all incoming calls to the service, checks to see if there’s an OAuth2
//	access token present in the incoming call’s HTTP header, and then calls back to the callback
//	URL defined in the security.oauth2.resource.userInfoUri to see if the token is valid.
// Once it knows the token is valid, the @EnableResourceServer annotation
// also applies any access control rules over who and what can access a service.
@SpringBootApplication
public class LicensingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicensingserviceApplication.class, args);
	}

}
