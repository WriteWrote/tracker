package tracker.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tracker.db.entity.TimePiecesEntity;

import java.util.UUID;

@Repository
public interface TimePiecesRepository extends JpaRepository<TimePiecesEntity, UUID> {
}
