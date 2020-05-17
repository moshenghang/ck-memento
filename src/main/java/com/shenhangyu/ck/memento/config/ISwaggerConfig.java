/**
 *版权所有©深航渔
 */
package com.shenhangyu.icard.icardweb.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.shenhangyu.icard.icardweb.controller.CardInfoController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置信息，访问地址：http://localhost:9010/icard-web/swagger-ui.html
 * @author moshenghang
 * @date 2020年5月16日
 */
@Profile({"dev"})//配置只有dev环境启用Swagger
@Configuration
@EnableSwagger2
public class ISwaggerConfig {
	private static Logger logger = LoggerFactory.getLogger(ISwaggerConfig.class);
	
	@Bean
	public Docket createApi(){
		logger.info("进入Swagger配置类");
		/**
		 * 配置Api Documentation信息
		 */
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("深航渔")
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.shenhangyu.icard.icardweb.controller"))//配置扫描的包
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo getApiInfo(){
		logger.info("开始重置Swagger配置参数");
		//作者信息
		Contact contactInfo = new Contact("shenhangyu","https://github.com/moshenghang","shenhangyu.qq.com");
		return new ApiInfoBuilder()
				.title("云卡管理工程 API接口文档")//文档标题
				.description("icard-web工程的SwaggerAPI文档")//文档说明
				.contact(contactInfo)//作者信息
				.termsOfServiceUrl("https://github.com/moshenghang")
				.version("v1.0.0")
				.build();
	}
}
