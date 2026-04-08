package integration;

import org.junit.jupiter.api.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Sql("db/migrations/user_controller_populate_db.sql")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ContextConfiguration(classes = {})
public class UserControllerTest {
    private static final String BASE_URL = "/user";


    @Test
    @Order(1)
    public void createUser_ReturnOk(){
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void createUser_ReturnAlreadyExists(){
        assertTrue(true);
    }

    @Test
    @Order(3)
    public void deleteUser_ReturnOk(){
        assertTrue(true);
    }
}
