package com.example.kalkulatorw.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class Rate {
    private String no;
    private Date effectiveDate;
    private Double mid;
}
