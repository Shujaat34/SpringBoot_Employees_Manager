package com.employees.app.swagconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket actionSwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("E-2-E Api's").tags(
                new Tag("Employee Api", "Repository for Users ")
        )
                .apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.employees.app")).
                        paths(regex("/.*")).build().pathMapping("/");

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Manager Project")
                .description("Swagger Integration Role Employee Manager")
                .termsOfServiceUrl("This Application is used for Learning Purpose")
                .license("Licensed by Bukhari")
                .licenseUrl("bukhari.com").version("1.0").build();
    }
}

