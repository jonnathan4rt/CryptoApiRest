package com.newpiece.rest.controller;

import com.newpiece.rest.controller.dto.CryptocurrencyDTO;
import com.newpiece.rest.entities.Cryptocurrency;
import com.newpiece.rest.service.ICryptocurrencyService;
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
        Optional<Cryptocurrency> cryptocurrencyOptional = cryptocurrencyService.findById(id);

        if (cryptocurrencyOptional.isPresent()){
            Cryptocurrency cryptocurrency = cryptocurrencyOptional.get();
            CryptocurrencyDTO cryptocurrencyDTO = CryptocurrencyDTO.builder()
                    .id(cryptocurrency.getId())
                    .name(cryptocurrency.getName())
                    .price(cryptocurrency.getPrice())
                    .volume(cryptocurrency.getVolume())
                    .capMaker(cryptocurrency.getCapMaker())
                    .symbol(cryptocurrency.getSymbol())
                    .exchange(cryptocurrency.getExchange())
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
                        .exchange(cryptocurrency.getExchange())
                        .build())
                .toList();
        return ResponseEntity.ok(cryptocurrencyDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCryptocurrency(@RequestBody CryptocurrencyDTO cryptocurrencyDTO) throws URISyntaxException {
        if (cryptocurrencyDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        cryptocurrencyService.save(Cryptocurrency.builder().name(cryptocurrencyDTO.getName()).build());
        return ResponseEntity.created(new URI("/api/cryptocurrency/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCryptocurrency(@PathVariable Long id, @RequestBody CryptocurrencyDTO cryptocurrencyDTO){
        Optional<Cryptocurrency> cryptocurrencyOptional = cryptocurrencyService.findById(id);

        if (cryptocurrencyOptional.isPresent()){
            Cryptocurrency cryptocurrency = cryptocurrencyOptional.get();
            cryptocurrency.setName(cryptocurrencyDTO.getName());
            cryptocurrencyService.save(cryptocurrency);
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
