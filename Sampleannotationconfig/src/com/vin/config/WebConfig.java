package com.vin.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@PropertySource("classpath:appexternal.properties")
@EnableTransactionManagement
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableWebMvc
@ComponentScan(basePackages = { "com.vin" })
@EnableSwagger2
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// ==================================== CROSS ORIGIN ====================================//
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE");
//		.allowedOrigins(
//				"http://localhost:8080", "http://localhost:4200", "http://192.168.0.9:4200", "http://127.0.0.1:8080",
//				"http://192.168.0.9:8080", "http://192.168.0.4:8080", "http://192.168.0.6:8080", "http://domain3.com");
	}

	// ====================================END CROSS ORIGIN ====================================//

	// ==================================== File Upload ====================================//

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		// no limit
		resolver.setMaxUploadSize(-1);
		return resolver;
	}

	// ==================================== END File Upload ====================================//

	// ==================================== SWAGGER ====================================//
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api.*"), regex("/api"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Vin Sample API").description("Vin API reference for developers")
				.termsOfServiceUrl("http://vinayak.com").contact("kamble.vinayak450@gmail.com")
				.license("Vinayak Kamble").licenseUrl("kamble.vinayak450@gmail.com").version("1.0").build();
	}
	// ==================================== END SWAGGER====================================//

}