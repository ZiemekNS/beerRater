package com.example.beerRater.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "beers")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 20)
    private String company;
    @Column(nullable = false, unique = true, length = 20)
    private String model;
    @Column(nullable = false, unique = true, length = 20)
    private int rate;
    @Column(nullable = false, unique = true, length = 60)
    private String comment;

    public Beer(String company, String model, int rate, String comment) {
        this.company = company;
        this.model = model;
        this.rate = rate;
        this.comment = comment;
    }
}
