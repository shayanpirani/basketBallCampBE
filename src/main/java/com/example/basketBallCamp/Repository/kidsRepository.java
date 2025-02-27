package com.example.basketBallCamp.Repository;

import com.example.basketBallCamp.Entity.kids;
import org.springframework.data.jpa.repository.JpaRepository;

public interface kidsRepository extends JpaRepository<kids, Long> {
    boolean existsBykidEmail(String email);
}
