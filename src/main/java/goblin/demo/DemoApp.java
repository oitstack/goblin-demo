package goblin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author yangguang
 * @date 2022/5/7
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:mybatis-conf.xml"})
public class DemoApp {
    public static void main(String[] args) {

        System.out.println("app start begin.");
        SpringApplication.run(DemoApp.class, args);
        System.out.println("app start end.");
    }
}
