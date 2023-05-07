package com.adias.demo.repository;

import com.adias.demo.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserrRepository extends JpaRepository<Userr,Integer> {
}
