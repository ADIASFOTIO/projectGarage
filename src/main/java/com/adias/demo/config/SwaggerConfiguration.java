package com.adias.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static com.adias.demo.utils.Constants.URL_GENERAL;
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("OFFICINA API DOCUMENTATION")
                                .title("OFFICINA REST API")
                                .build()
                )
                .groupName("REST API VERSION1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.adias.demo"))
                .paths(PathSelectors.ant(URL_GENERAL + "/**"))
                .build();
    }
}
