package com.example.beerRater.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String propertyName;
    @Column
    private String landlordName;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate reservationStartDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate reservationEndDate;

    public Property(String company, String model, LocalDate reservationStartDate, LocalDate reservationEndDate) {
        this.propertyName = company;
        this.landlordName = model;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
    }
}
