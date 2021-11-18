package com.example.beerRater;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.beerRater.domain.Beer;
import com.example.beerRater.repositories.BeerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserRepositoryTests {


    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testRateBeer() {
        Beer beer = new Beer();
        beer.setCompany("Warka");
        beer.setModel("Radler");
        beer.setRate(4);
        beer.setComment("No fajno nie");

        Beer savedBeer = beerRepository.save(beer);

        Beer existBeer = entityManager.find(Beer.class, savedBeer.getId());

        assertThat(existBeer.getCompany()).isEqualTo(beer.getCompany());
    }
}
