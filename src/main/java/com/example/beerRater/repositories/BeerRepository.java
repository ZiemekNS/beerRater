package com.example.beerRater.repositories;

import java.util.List;
import com.example.beerRater.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer> {
    @Query(value = "SELECT * FROM Beers WHERE company LIKE %:keyword% or model like %:keyword%", nativeQuery = true)
    List<Beer> findByKeyword(@Param("keyword") String keyword);
}
