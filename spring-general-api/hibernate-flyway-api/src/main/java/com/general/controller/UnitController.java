package com.general.controller;

import com.general.dao.Unit;
import com.general.service.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class UnitController {

    private final UnitService service;

    public UnitController(UnitService service) {
        this.service = service;
    }

    @PostMapping(value = "/unit")
    public ResponseEntity<Unit> createUnit(){
        return new ResponseEntity<>(service.createUnit(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/unit")
    public ResponseEntity<List<Unit>> getUnit(){
        return new ResponseEntity<>(service.getUnit(),HttpStatus.OK);
    }

    @PutMapping(value = "/unit/{id}")
    public ResponseEntity<Unit> updateUnit(@PathVariable Long id){
        return new ResponseEntity<>(service.updateUnit(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/unit/{id}")
    public ResponseEntity<?> deleteUnit(@PathVariable Long id){
        service.deleteUnit(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
