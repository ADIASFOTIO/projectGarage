package com.adias.demo.repository;
import com.adias.demo.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserrRepository extends JpaRepository<Userr,Integer> {
}
