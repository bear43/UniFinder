package repository;

import model.Specialization;
import model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long>
{
    List<Specialization> findAllByTitle(String title);
    List<Specialization> findAllByUniversity(University university);
}
