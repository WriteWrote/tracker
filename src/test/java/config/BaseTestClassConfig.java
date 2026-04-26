package config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;
import tracker.Main;

@Testcontainers
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@SpringBootTest(classes = Main.class)
@ContextConfiguration(initializers = {DockerPostgreDataSourceInitializer.class})
public class BaseTestClassConfig {
}
