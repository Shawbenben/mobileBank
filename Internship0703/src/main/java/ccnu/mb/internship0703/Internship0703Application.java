package ccnu.mb.internship0703;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ccnu.mb.internship0703.mapper")
public class Internship0703Application {

    public static void main(String[] args) {

        SpringApplication.run(Internship0703Application.class, args);


    }

}
