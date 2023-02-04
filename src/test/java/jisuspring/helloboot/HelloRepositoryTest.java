package jisuspring.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
public class HelloRepositoryTest {

    @Autowired
    HelloRepository helloRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("Jisu")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("Jisu")).isEqualTo(0);

        helloRepository.increaseCount("Jisu");
        assertThat(helloRepository.countOf("Jisu")).isEqualTo(1);

        helloRepository.increaseCount("Jisu");
        assertThat(helloRepository.countOf("Jisu")).isEqualTo(2);
    }
}
