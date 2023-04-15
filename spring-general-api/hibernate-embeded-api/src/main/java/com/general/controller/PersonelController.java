package com.general.controller;

import com.general.dao.Personel;
import com.general.service.PersonelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class PersonelController {

    private final PersonelService service;

    public PersonelController(PersonelService service) {
        this.service = service;
    }

    @PostMapping(value = "/embeded")
    public ResponseEntity<Personel> createPersonel(){
        return new ResponseEntity<>(service.createPersonel(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/embeded")
    public ResponseEntity<List<Personel>> getPersonel(){
        return new ResponseEntity<>(service.getPersonel(),HttpStatus.OK);
    }


}
