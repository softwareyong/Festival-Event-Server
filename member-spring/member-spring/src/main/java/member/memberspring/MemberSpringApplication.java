package member.memberspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MemberSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberSpringApplication.class, args);
	}

}
