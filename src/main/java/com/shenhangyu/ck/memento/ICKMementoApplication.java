package com.shenhangyu.icard.icardweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableEurekaClient
@SpringBootApplication
public class IcardWebApplication {

	/**
	 * 使用@Bean注解方式fastJsonHttpMessageConvert解析对象
	 * @param args
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		//实例化FastJson转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//实例化FastJson配置对象
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//将FastJson配置参数放进转换器
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(IcardWebApplication.class, args);
    }

}
