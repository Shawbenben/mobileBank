package ccnu.intern.mobilebanktest01;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mobilebanktest01ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test(){

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mobilebank?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true",
                        "root", "1234")
                .globalConfig(builder -> builder
                        .author("intern")
                        .outputDir("D:/develp/JavaProject/Mobilebanktest01/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("ccnu.intern.mobilebanktest01")
                        .entity("pojo")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
