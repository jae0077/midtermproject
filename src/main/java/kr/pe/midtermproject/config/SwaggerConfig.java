package kr.pe.midtermproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2  
public class SwaggerConfig {
	
    @Bean
    public Docket swaggerApi() {
    	
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("kr.pe.midtermproject.controller"))
                .build()
                .useDefaultResponseMessages(false); 
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("Saraksarak API Documentation")
                .description("Saraksarak 홈페이지의 REST API 내용을 확인하실 수 있습니다.")
                .license("license : Sarak Crew").licenseUrl("http://localhost")
                .version("1").build();
    }
    
}
