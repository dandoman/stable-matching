package com.construction;

import com.construction.util.SerializationUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class App {

	//Build the primary object mapper to return joda datetimes as ISO 8601
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		return SerializationUtil.buildMapper();
	}

	@Bean(name = "txManager")
	public PlatformTransactionManager transactionManager(@Qualifier("ds") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}


	@Bean
	@Primary
	@Qualifier("ds")
	@ConfigurationProperties(prefix = "datasource.postgres")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
