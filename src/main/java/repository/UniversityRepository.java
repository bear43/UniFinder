package repository;

import model.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long>
{
    University findByTitle(String title);
    University findByAddress(String address);
    University findByNumber(String number);
    List<University> findAllByProfile(String profile);
}
