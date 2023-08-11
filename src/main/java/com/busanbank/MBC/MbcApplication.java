package com.busanbank.MBC;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = MbcApplication.class)
@SpringBootApplication
public class MbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbcApplication.class, args);
	}
}
