package ru.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onboarding.model.RoomModel;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Integer> {
}
