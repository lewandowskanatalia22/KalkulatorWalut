package com.example.kalkulatorw.service;

import com.example.kalkulatorw.dto.ExchangeRatesSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
@Service
public class KursNBPService {
    @Autowired
    RestTemplate restTemplate;

    public ExchangeRatesSeries getCurrentExchangeRateForCurrencyCode(String currencyCode) {
        ResponseEntity<ExchangeRatesSeries> exchangeRateDto = restTemplate.getForEntity(getUri(currencyCode).toUri(), ExchangeRatesSeries.class);
        return exchangeRateDto.getBody();
    }

    private UriComponents getUri(String currencyCode) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("currencyCode", currencyCode);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host("api.nbp.pl").path("/api/exchangerates/rates/a").path("/{currencyCode}").buildAndExpand(parameters);
        return uriComponents;
    }
}
