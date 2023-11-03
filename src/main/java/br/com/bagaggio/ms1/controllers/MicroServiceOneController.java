package br.com.bagaggio.ms1.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping
public class MicroServiceOneController {

    @GetMapping("/cep")
    @CircuitBreaker(name = "sentEmailCb")
    public CepDto findWorld() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepDto> resp = restTemplate.getForEntity("https://viacep.com.br/ws/01001000/json", CepDto.class);
        return resp.getBody();
    }
}
