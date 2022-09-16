
package com.easy.city.codegen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 代码生成模块
 * @author ZhangYuting
 */
@MapperScan("com.easy.city.codegen.mapper")
@SpringBootApplication
public class CodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeGenApplication.class, args);
	}
}
