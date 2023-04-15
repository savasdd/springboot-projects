package com.general.controller;

import com.general.dao.CPersonel;
import com.general.service.CPersonelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class CPersonelController {

    private final CPersonelService personelService;

    public CPersonelController(CPersonelService personelService) {
        this.personelService = personelService;
    }

    @PostMapping(value = "/cpersonels")
    public ResponseEntity<CPersonel> create(@RequestBody CPersonel personel){
        return new ResponseEntity<>(personelService.create(personel), HttpStatus.CREATED);
    }

    @GetMapping(value = "/cpersonels")
    public ResponseEntity<List<CPersonel>> getAll(){
        return new ResponseEntity<>(personelService.getAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/cpersonels/{id}")
    public ResponseEntity<CPersonel> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(personelService.getById(id),HttpStatus.OK);
    }
}
