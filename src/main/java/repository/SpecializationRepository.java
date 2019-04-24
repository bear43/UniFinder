package repository;

import model.Specialization;
import model.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization, Long>
{
    List<Specialization> findAllByTitle(String title);
    List<Specialization> findAllByUniversity(University university);
}
