package config;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.postgresql.PostgreSQLContainer;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DockerPostgreDataSourceInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    /**
     * static будет здесь означать, что контейнер используется для всех тестов, а не переподнимается заново
     */
    @Container
    private final PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:12.1.1")
            .withDatabaseName("postgres")
            .withUsername("postgres")
            .withPassword("postgres")
            .withInitScript("db/migrations/init_test.sql");

    @Override
    public void initialize(@NotNull ConfigurableApplicationContext applicationContext) {
        postgreSQLContainer.start();
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                applicationContext,
                "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                "spring.datasource.password=" + postgreSQLContainer.getPassword(),
                "spring.datasource.driver-class-name=org.postgresql.Driver"
        );
    }
}
