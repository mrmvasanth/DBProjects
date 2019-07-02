package com.packs.flyy;

import com.packs.flyy.models.entity.Users;
import com.packs.flyy.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Library;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class FlyyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyyApplication.class, args);
	}


}
