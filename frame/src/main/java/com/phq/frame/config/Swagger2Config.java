package com.phq.frame.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
* @ClassName: Swagger2Config
* @Description: 
*   Swagger2  配置文件 配置生成基础的 api信息
* @author panhuaqing
* @date 2018年12月31日 下午5:16:48
*http://localhost:8080/swagger-ui.html
 */
@SpringBootConfiguration
@EnableSwagger2
public class Swagger2Config {
	
	//swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)

                .apiInfo(apiInfo())

                .select()

                //api选择的包路径 其实就是你需要生成api的包 
                .apis(RequestHandlerSelectors.basePackage("com.phq.frame.controller"))

                .paths(PathSelectors.any())

                .build();

    }
	
    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()

                //页面标题

                .title("Spring Boot使用 Swagger2 构建 RESTful API")

                //创建人

                .contact(new Contact("panhuaqing", "http://www.baidu.com", ""))

                //版本号

                .version("1.0")

                //描述

                .description("frame API 描述")

                .build();

    }
}
