package repository;

import model.Condition;
import model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConditionRepository extends JpaRepository<Condition, Long>
{
    List<Condition> findAllByPointsCount(int pointCount);
    List<Condition> findAllBySubject(Subject subject);
}
