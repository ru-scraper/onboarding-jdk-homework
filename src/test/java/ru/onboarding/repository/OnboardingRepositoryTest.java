package ru.onboarding.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.onboarding.model.RoomModel;
import ru.onboarding.model.StudentModel;

@SpringBootTest
@Testcontainers
class OnboardingRepositoryTest {

    @Container
    private static final PostgreSQLContainer<?> POSTGRESQL_CONTAINER =
            new PostgreSQLContainer<>("postgres:14.2")// Создать контейнер из образа postgres:11
                    .withInitScript("db.sql");// Выполнить db.sql после запуска

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoomRepository roomRepository;

    @DynamicPropertySource
    static void postgreSQLProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRESQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRESQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRESQL_CONTAINER::getPassword);
    }

    /**
     * Создание аудитории и запись одного студента
     * Проверка на корректную запись
     */
    @Test
    void testCase1() {
        RoomModel roomModel = new RoomModel(1);
        roomRepository.save(roomModel);
        studentRepository.save(new StudentModel(1, "name", roomModel));

        Assertions.assertEquals(1, studentRepository.getStudentCountByRoomId(roomModel.getId()));
        Assertions.assertEquals(1, roomRepository.findById(roomModel.getId()).get().getStudents().size());
    }

}