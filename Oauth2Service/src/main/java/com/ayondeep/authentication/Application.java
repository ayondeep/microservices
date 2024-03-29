package com.ayondeep.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer  // Tells Spring cloud that this service is going to act as an OAuth2 service
public class Application {

    /**
     * This is called by a protected resource to validate the OAuth2 access token and retrieve
     * the assigned roles of the user accessing the protected resource.
     * @param user
     * @return
     */
    @RequestMapping(value = { "/user" }, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put(
                "user",
                user.getUserAuthentication()
                        .getPrincipal());
        userInfo.put("authorities",
                AuthorityUtils.authorityListToSet(
                        user.getUserAuthentication().getAuthorities()));
        System.out.println("Validating user " + user.getName());
        return userInfo;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}



