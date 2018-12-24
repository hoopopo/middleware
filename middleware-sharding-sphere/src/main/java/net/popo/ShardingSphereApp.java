package net.popo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan("net.popo.*.dao")
public class ShardingSphereApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ShardingSphereApp.class, args);
	}
}
