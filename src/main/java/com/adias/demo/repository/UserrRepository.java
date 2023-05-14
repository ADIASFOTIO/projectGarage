package com.adias.demo.repository;
import com.adias.demo.model.Userr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserrRepository extends GenericRepository<Userr,Integer> {
    // JPQL query
    Optional<Userr> findByMail(String mail);
}
