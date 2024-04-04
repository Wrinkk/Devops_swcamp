package com.ohgiraffers.bootproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* 설명. Rest-API 서버측에서 CORS 처리를 위한 설정 클래스 */

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                /* 설명. vue 프로젝트를 8011로 접근 되게 포트포워딩(8011:5173) 해서 컨테이너를 만들면 CORS 경로가 바뀔 수 있다. */
                .allowedOrigins("http://localhost:8011","http://localhost:5173")
                .allowCredentials(true)
                .allowedHeaders("x-requested-with", "authorization", "content-type", "credential", "X-AUTH-TOKEN", "X-CSRF-TOKEN")
                .allowedMethods("POST", "GET", "PUT", "PATCH", "DELETE", "OPTIONS");
    }


}
