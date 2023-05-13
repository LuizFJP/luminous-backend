package com.br.luminous.controller;
import com.br.luminous.models.DealershipRequest;
import com.br.luminous.models.DealershipResponse;
import com.br.luminous.entity.Dealership;
import com.br.luminous.service.DealershipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/dealership")
public class DealershipController {

    private DealershipService dealershipService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<String> teste() {
        return new ResponseEntity<String>("Deu certo", HttpStatus.CREATED);
    }


    @PostMapping
    public ResponseEntity<Long> createealDealership(@RequestBody Dealership dealership){
        Long id = dealershipService.create(dealership);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DealershipResponse> updateDealership(@PathVariable Long id, @RequestBody DealershipRequest dealership) {
        dealershipService.update(id, dealership);
        return new ResponseEntity(dealership, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDealership(@PathVariable Long id) {
        dealershipService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
