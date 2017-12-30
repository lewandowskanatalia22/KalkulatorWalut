package com.example.kalkulatorw.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "KURSY")
@Data
public class Kurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Double kursWaluty;
    private String symbol;

    @Override
    public String toString() {
        return String.format(
                "KURSY[id=%d, date='%s', kursWaluty='%s', symbol='%s']",
                id, date, kursWaluty, symbol);
    }

}
