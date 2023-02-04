package jisuspring.helloboot;

import jisuspring.config.MySpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@MySpringBootApplication
public class HellobootApplication {
    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    // 여기보다 우선시되는것은 OS 환경 변수이다.
    //인텔리제이는 에딧컨피규레이션에서 설정할 수 있다.
    //OS 보다 우선은 시스템 프로퍼티이다. == 자바 명령어로 시스템을 구동시킬때.
//    @Bean
//    ApplicationRunner applicationRunner(Environment env) {
//        return args -> {
//            String name = env.getProperty("my.name");
//            System.out.println("name = " + name);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }


}
