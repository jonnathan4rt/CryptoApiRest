package com.newpiece.rest.controller;


import com.newpiece.rest.controller.dto.ExchangeDTO;
import com.newpiece.rest.entities.ExchangeEntity;
import com.newpiece.rest.service.IExchangeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {
    @Autowired
    private IExchangeService exchangeService;
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<ExchangeEntity> exchangeOptional = exchangeService.findById(id);

        if (exchangeOptional.isPresent()){
            ExchangeEntity exchangeEntity = exchangeOptional.get();
            ExchangeDTO exchangeDTO = ExchangeDTO.builder()
                    .id(exchangeEntity.getId())
                    .name(exchangeEntity.getName())
                    .baseUser(exchangeEntity.getBaseUser())
                    .location(exchangeEntity.getLocation())
                    .numCrypto(exchangeEntity.getNumCrypto())
                    .cryptocurrencyEntityList(exchangeEntity.getCryptocurrencyEntityList())
                    .build();
            return ResponseEntity.ok(exchangeDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<ExchangeDTO> exchangeDTOSList = exchangeService.findAll()
                .stream()
                .map(exchange -> ExchangeDTO.builder()
                        .id(exchange.getId())
                        .name(exchange.getName())
                        .baseUser(exchange.getBaseUser())
                        .numCrypto(exchange.getNumCrypto())
                        .location(exchange.getLocation())
                        .cryptocurrencyEntityList(exchange.getCryptocurrencyEntityList())
                        .build())
                .toList();
        return ResponseEntity.ok(exchangeDTOSList);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveExchange(@Valid @RequestBody ExchangeDTO exchangeDTO) throws URISyntaxException {

        if (exchangeDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();

        }
        exchangeService.save(ExchangeEntity.builder()
                        .name(exchangeDTO.getName())
                        .location(exchangeDTO.getLocation())
                        .numCrypto(exchangeDTO.getNumCrypto())
                        .baseUser(exchangeDTO.getBaseUser())
                .build());
        return ResponseEntity.created(new URI("/api/exchangeEntity/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateExchange(@PathVariable Long id, @RequestBody ExchangeDTO exchangeDTO){
        Optional<ExchangeEntity> exchangeOptional = exchangeService.findById(id);

        if (exchangeOptional.isPresent()){
            ExchangeEntity exchangeEntity = exchangeOptional.get();
            exchangeEntity.setName(exchangeDTO.getName());
            exchangeService.save(exchangeEntity);
            return ResponseEntity.ok("Up-to-date registration");
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if (id != null){
            exchangeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("The id parameter is empty");
    }
}
