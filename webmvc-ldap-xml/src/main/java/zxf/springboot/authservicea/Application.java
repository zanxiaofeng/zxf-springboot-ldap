package zxf.springboot.authservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

// 安全配置以 spring-security.xml 为唯一权威，排除 Boot 默认的 SecurityFilterChain 自动配置以免别名冲突
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ImportResource("classpath:spring-security.xml")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
