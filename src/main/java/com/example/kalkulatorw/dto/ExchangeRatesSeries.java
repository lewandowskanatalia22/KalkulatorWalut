package com.example.kalkulatorw.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExchangeRatesSeries {
    String table;
    String currency;
    String code;
    List<Rate> rates;
}
