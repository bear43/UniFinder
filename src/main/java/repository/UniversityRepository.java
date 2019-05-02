package repository;

import model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long>
{
    University findByTitle(String title);
    University findByAddress(String address);
    University findByNumber(String number);
    List<University> findAllByProfile(String profile);
}
