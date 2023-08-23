/* More comments can be found in GliderController.java */
package com.springboot.application.model;
import com.springboot.application.model.Helicopter;
import com.springboot.application.service.HelicopterService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path="api/v1/helicopters")
public class HelicopterController {

    private final HelicopterService helicopterService;

    @Autowired
    public HelicopterController(HelicopterService helicopterService) {
        this.helicopterService = helicopterService;
    }

    // For GET method - retrieve ALL
    @GetMapping
    public List<Helicopter> getHelicopters() {
        return helicopterService.getHelicopters();
    }

    // For GET method - retrieve ONE
    @GetMapping("{tailNumber}") 
    public ResponseEntity<?> getOneHelicopter (@PathVariable("tailNumber") String tailNumber) {
        try {
            helicopterService.getOneHelicopter(tailNumber);
        } catch (NullPointerException e) { 
            return new ResponseEntity<>("Helicopter with this tail number, " + tailNumber + ", does not exist.  Not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(helicopterService.getOneHelicopter(tailNumber), HttpStatus.OK);
    }


    // For POST method
    @PostMapping
    public ResponseEntity<String> createHelicopter(@RequestBody Helicopter helicopter) {
        try {
            helicopterService.createHelicopter(helicopter.getTailNumber(), helicopter.getNumberOfWheels(), helicopter.getLength(), helicopter.getRotorRpm());
        } catch (NullPointerException e) {
            return new ResponseEntity<>("Helicopter can't be created", HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>("Helicopter has been created", HttpStatus.CREATED);
    }

    // for DELETE method
    @DeleteMapping("{tailNumber}") 
    public ResponseEntity<String> deleteHelicopter(@PathVariable("tailNumber") String tailNumber) {
        var isRemoved = helicopterService.deleteHelicopter(tailNumber);
        if (!isRemoved) {
            return new ResponseEntity<>("Helicopter with this tail number, " + tailNumber + ", does not exist.  Cannot delete.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Helicopter with this tail number, " + tailNumber + ", has been deleted.", HttpStatus.OK);
    }

    // for UPDATE method
    @PutMapping("{tailNumber}")
    public ResponseEntity<String> updateHelicopter(@PathVariable("tailNumber") String tailNumber, @RequestBody Helicopter newHelicopterDetails) {
        try {
            var helicopterExists = helicopterService.updateHelicopter(tailNumber, newHelicopterDetails);
            if (!helicopterExists) {
                return new ResponseEntity<>("Helicopter with this tail number, " + tailNumber + ", does not exist.  Cannot modify.", HttpStatus.BAD_REQUEST);
            }
        } catch (NullPointerException e) {
            return new ResponseEntity<>("Helicopter can't be modified", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Helicopter with this tail number, " + tailNumber + ", has been modified", HttpStatus.OK);
    }
}