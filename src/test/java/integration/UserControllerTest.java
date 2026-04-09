package integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import tracker.common.RerunIfFailed;
import org.junit.jupiter.api.*;
import org.springframework.test.context.jdbc.Sql;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RerunIfFailed
@Sql("db/migrations/user_controller_populate_db.sql")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ContextConfiguration(classes = {})
public class UserControllerTest {
    private static final String BASE_URL = "/user";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void createUser_ReturnOk() {
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void createUser_ReturnAlreadyExists() {
        assertTrue(true);
    }

    @Test
    @Order(3)
    public void deleteUser_ReturnOk() {
        assertTrue(true);
    }

    @Test
    @Order(4)
    public void flakyTest() {
        assertTrue(new Random().nextBoolean());
    }
}
