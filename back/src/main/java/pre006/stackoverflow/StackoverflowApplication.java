package pre006.stackoverflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pre006.stackoverflow.domain.user.controller.UserController;
import pre006.stackoverflow.testdata.TestDataInit;

@EnableJpaAuditing // JPA Auditing(감시) 기능을 활성화하기 위한 어노테이션
@SpringBootApplication
public class StackoverflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackoverflowApplication.class, args);
	}

}
