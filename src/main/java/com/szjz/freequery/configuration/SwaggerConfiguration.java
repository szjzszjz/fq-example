package com.szjz.freequery.configuration;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问链接<br>
 * http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.szjz.freequery.configuration","com.szjz.freequery.controller"})
public class SwaggerConfiguration {
    @Autowired
    private SwaggerProperties swaggerProperties;

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfiguration.class);

    /** 可以存在多个docket 一个bean 代表一组 */
    @Bean
    public Docket createRestApi() {
        LOGGER.info("【Swagger】 initializing");
        LOGGER.info("【Swagger】 group name: {}",swaggerProperties.getGroupName());
        List<Parameter> parameters = new ArrayList<>();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)//
                .select()//
                .paths(PathSelectors.any())//匹配url路径any():任何路径  ant("v1/api/..."):指定路径
                .build()//
                .pathMapping("/")
                .globalOperationParameters(parameters)
                .groupName(swaggerProperties.getGroupName())//组名
                .apiInfo(apiInfo());//
//                .host(configProperties.getApp().getApiDomain());


        ApiSelectorBuilder builder = docket.select();
        if (!StringUtils.isEmpty(swaggerProperties.getBasePackage())){
            LOGGER.info("【Swagger】 base package: {}",swaggerProperties.getBasePackage());
            builder.apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()));
        }
        if (!StringUtils.isEmpty(swaggerProperties.getPath())){
            LOGGER.info("【Swagger】 path: {}",swaggerProperties.getPath());
            builder.paths(PathSelectors.ant(swaggerProperties.getPath()));
        }
        LOGGER.info("【Swagger】 initialized successful");
        return docket;
    }

    private ApiInfo apiInfo() {
        LOGGER.info("【swagger】 title: {}",swaggerProperties.getTitle());
        LOGGER.info("【swagger】 desc: {}",swaggerProperties.getDesc());
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())                                      //标题
                .description(swaggerProperties.getDesc())                               //描述
                .contact(new Contact("石中君子", "", ""))
                .version("1.0")
                .build();

    }

}
