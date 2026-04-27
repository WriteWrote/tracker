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
import tracker.common.Headers;
import tracker.common.RerunIfFailed;
import tracker.db.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    public void createUser_ReturnOk() throws Exception {
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
        var userEntity = userRepository.findByLogin(userDtoNoId.getLogin()).orElseThrow();
        assertEquals(userDtoNoId.getLogin(), userEntity.getLogin());
        assertEquals(userDtoNoId.getGrade(), userEntity.getGrade());
        assertEquals(userDtoNoId.getPosition(), userEntity.getPosition());
        assertEquals(1, userEntity.getAssignedProjects().size());
        assertEquals(userDtoNoId.getProjectId(), userEntity.getAssignedProjects().getFirst().getId());
    }

    @Test
    @Order(2)
    public void createUser_ReturnAlreadyExists() throws Exception {
        var userDto = userDtoProvider.getValidUserDto().setLogin("Existing user");
        mockMvc.perform(post(BASE_URL + "/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto))
                ).andExpect(status().isCreated())
                .andReturn();
        var response = mockMvc.perform(post(BASE_URL + "/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto))
                ).andExpect(status().isInternalServerError())
                .andReturn();
        assertEquals("Error while creating user", response.getResponse().getHeader(Headers.SERVER_MESSAGE.getValue()));
    }

    @Test
    @Order(3)
    public void deleteUser_ReturnOk() throws Exception {
        var userDto = userDtoProvider.getValidUserDto();
        mockMvc.perform(post(BASE_URL + "/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto))
                ).andExpect(status().isCreated())
                .andReturn();
        var createdUserId = userRepository.findByLogin(userDto.getLogin()).orElseThrow().getId();
        mockMvc.perform(post(BASE_URL + "/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createdUserId))
                ).andExpect(status().isOk())
                .andReturn();
        assertTrue(userRepository.findById(createdUserId).isEmpty());
    }

    @Test
    @Order(4)
    public void deleteUser_notExists() {

    }

    @Test
    @Order(5)
    public void getUserById_ok() {

    }

    @Test
    @Order(6)
    public void getUserById_notExists() {

    }

    @Test
    @Order(7)
    public void assignProjectToUser_projectExists_userExists() {

    }

    @Test
    @Order(8)
    public void assignProjectToUser_projectExists_userNotExists() {

    }

    @Test
    @Order(9)
    public void assignProjectToUser_projectNotExists_userExists() {

    }

    /**
     * Флаки-тест для иллюстрации работы gradle-плагина для перезапуска падающих тестов
     * Плагин перезапускает тест еще 2 раза, и помечает билд успешным, если повторные прогоны были успешными
     * Если все повторные прогоны были неуспешными, то тест помечается упавшим
     */
    @Test
    @Order(101)
    public void flakyTest() {
        assertTrue(new Random().nextBoolean());
    }
}
