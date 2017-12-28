package com.example.kalkulatorw;

import com.example.kalkulatorw.dto.ExchangeRatesSeries;
import com.example.kalkulatorw.service.KursNBPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    KursNBPService kursNBPService;

    @RequestMapping("/{kraj}")

    public String hello(@PathVariable String kraj, @RequestParam String kwota) {
        ExchangeRatesSeries exchangeRatesSeries= kursNBPService.getCurrentExchangeRateForCurrencyCode(kraj);
        Double wartosc=Double.valueOf(kwota);
        return String.valueOf(wartosc*exchangeRatesSeries.getRates().get(0).getMid());
    }
}
