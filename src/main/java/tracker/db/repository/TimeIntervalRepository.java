package tracker.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tracker.db.entity.TimeIntervalEntity;

import java.util.UUID;

@Repository
public interface TimeIntervalRepository extends JpaRepository<TimeIntervalEntity, UUID> {
}
