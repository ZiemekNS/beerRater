package com.example.beerRater.repositories;

import java.util.List;
import com.example.beerRater.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

    @Query(value = "SELECT * FROM Properties WHERE PROPERTY_NAME LIKE %:keyword% OR LANDLORD_NAME LIKE %:keyword%", nativeQuery = true)
    List<Property> findByKeyword(@Param("keyword") String keyword);
}
