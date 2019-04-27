package repository;

import model.Condition;
import model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long>
{
    List<Condition> findAllByPointsCount(int pointCount);
    List<Condition> findAllBySubject(Subject subject);
}
