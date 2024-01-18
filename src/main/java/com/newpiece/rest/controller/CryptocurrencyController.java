package com.newpiece.rest.controller;

import com.newpiece.rest.controller.dto.CryptocurrencyDTO;
import com.newpiece.rest.entities.CryptocurrencyEntity;
import com.newpiece.rest.service.ICryptocurrencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cryptocurrency")
public class CryptocurrencyController {

    @Autowired
    private ICryptocurrencyService cryptocurrencyService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<CryptocurrencyEntity> cryptocurrencyOptional = cryptocurrencyService.findById(id);

        if (cryptocurrencyOptional.isPresent()){
            CryptocurrencyEntity cryptocurrencyEntity = cryptocurrencyOptional.get();
            CryptocurrencyDTO cryptocurrencyDTO = CryptocurrencyDTO.builder()
                    .id(cryptocurrencyEntity.getId())
                    .name(cryptocurrencyEntity.getName())
                    .price(cryptocurrencyEntity.getPrice())
                    .volume(cryptocurrencyEntity.getVolume())
                    .capMaker(cryptocurrencyEntity.getCapMaker())
                    .symbol(cryptocurrencyEntity.getSymbol())
                    .exchangeEntity(cryptocurrencyEntity.getExchangeEntity())
                    .build();
            return ResponseEntity.ok(cryptocurrencyDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<CryptocurrencyDTO> cryptocurrencyDTOList = cryptocurrencyService.findAll()
                .stream()
                .map(cryptocurrency -> CryptocurrencyDTO.builder()
                        .id(cryptocurrency.getId())
                        .name(cryptocurrency.getName())
                        .price(cryptocurrency.getPrice())
                        .volume(cryptocurrency.getVolume())
                        .capMaker(cryptocurrency.getCapMaker())
                        .symbol(cryptocurrency.getSymbol())
                        .exchangeEntity(cryptocurrency.getExchangeEntity())
                        .build())
                .toList();
        return ResponseEntity.ok(cryptocurrencyDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCryptocurrency(@Valid @RequestBody CryptocurrencyDTO cryptocurrencyDTO) throws URISyntaxException {
        if (cryptocurrencyDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        cryptocurrencyService.save(CryptocurrencyEntity.builder()
                        .name(cryptocurrencyDTO.getName())
                        .symbol(cryptocurrencyDTO.getSymbol())
                        .price(cryptocurrencyDTO.getPrice())
                        .capMaker(cryptocurrencyDTO.getCapMaker())
                        .volume(cryptocurrencyDTO.getVolume())
                        .exchangeEntity(cryptocurrencyDTO.getExchangeEntity())
                .build());
        return ResponseEntity.created(new URI("/api/cryptocurrency/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCryptocurrency(@PathVariable Long id, @RequestBody CryptocurrencyDTO cryptocurrencyDTO){
        Optional<CryptocurrencyEntity> cryptocurrencyOptional = cryptocurrencyService.findById(id);

        if (cryptocurrencyOptional.isPresent()){
            CryptocurrencyEntity cryptocurrencyEntity = cryptocurrencyOptional.get();
            cryptocurrencyEntity.setName(cryptocurrencyDTO.getName());
            cryptocurrencyService.save(cryptocurrencyEntity);
            return ResponseEntity.ok("Up-to-date registration");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if (id != null){
            cryptocurrencyService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("The id parameter is empty");
    }

}
