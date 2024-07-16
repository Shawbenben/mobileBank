package ccnu.intern.mobilebanktest01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ccnu.intern.mobilebanktest01.mapper")
public class Mobilebanktest01Application {

    public static void main(String[] args) {

        SpringApplication.run(Mobilebanktest01Application.class, args);
    }

}
