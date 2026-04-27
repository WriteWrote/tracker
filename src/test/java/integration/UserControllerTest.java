package integration;

import config.BaseTestClassConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
//import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import providers.TestUserDtoProvider;
import tools.jackson.databind.ObjectMapper;
import tracker.common.RerunIfFailed;
import tracker.model.dto.LightUserDto;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RerunIfFailed
@Sql("/db/migrations/user_controller_populate_db.sql")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {TestUserDtoProvider.class})
public class UserControllerTest extends BaseTestClassConfig {
    private static final String BASE_URL = "/user";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestUserDtoProvider userDtoProvider;

    @Test
    @Order(1)
    public void createUser_ReturnOk() {
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void createUser_ReturnAlreadyExists() throws Exception {
        var userDtoNoId = userDtoProvider.getValidUserDto();
        var response = mockMvc.perform(post(BASE_URL + "/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDtoNoId))
                ).andExpect(status().isCreated())
                .andReturn();
        var responseDto = objectMapper.readValue(response.getResponse().getContentAsString(), LightUserDto.class);
        assertNotNull(responseDto);
        assertEquals(userDtoNoId.getLogin(), responseDto.getLogin());
        assertEquals(userDtoNoId.getGrade(), responseDto.getGrade());
        assertEquals(userDtoNoId.getPosition(), responseDto.getPosition());
        // todo check writing to db?
    }

    @Test
    @Order(3)
    public void deleteUser_ReturnOk() {
        assertTrue(true);
    }

    /**
     * Флаки-тест для иллюстрации работы gradle-плагина для перезапуска падающих тестов
     * Плагин перезапускает тест еще 2 раза, и помечает билд успешным, если повторные прогоны были успешными
     * Если все повторные прогоны были неуспешными, то тест помечается упавшим
     */
    @Test
    @Order(4)
    public void flakyTest() {
        assertTrue(new Random().nextBoolean());
    }
}
