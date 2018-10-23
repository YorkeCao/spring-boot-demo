package io.yorkecao.springbootdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;

/**
 * @author Yorke
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring-boot-demo")
public class SpringBootDemoConfiguration {

    @NotBlank String name;

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
