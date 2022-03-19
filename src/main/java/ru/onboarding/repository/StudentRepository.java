package ru.onboarding.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.onboarding.model.StudentModel;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Integer> {

    //TODO реализовать запрос на количество студентов в аудитории
    long getStudentCountByRoomId(int roomId);

}
