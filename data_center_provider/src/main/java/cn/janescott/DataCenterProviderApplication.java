package cn.janescott;

import cn.janescott.common.StartupRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataCenterProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCenterProviderApplication.class, args);
	}

	@Bean
	public StartupRunner startupRunner(){
		return new StartupRunner();
	}
}
