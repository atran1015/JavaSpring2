package com.springboot.application.model;
import com.springboot.application.model.Jet;
import com.springboot.application.service.JetService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path="api/v1/jets")
public class JetController {

    private final JetService jetService;

    // Constructor
    @Autowired // Instantiates the glider service first, then inject it into the constructor
    public JetController(JetService jetService) {
        this.jetService = jetService;
    }

    // For GET method
    @GetMapping
    public List<Jet> getJets() {
        return jetService.getJets();
    }


    // For POST method
    @PostMapping
    public void createJet(@RequestBody Jet jet) {
        jetService.createJet(jet.getTailNumber(), jet.getNumberOfWheels(), jet.getLength(), jet.getFuel());
    }

    // for DELETE method
    @DeleteMapping("{tailNumber}") // full access to url would be http://localhost:8080/api/v1/jets/1abc
    public ResponseEntity<String> deleteJet(@PathVariable("tailNumber") String tailNumber) {

        var isRemoved = jetService.deleteJet(tailNumber);
        // if jet is not deleted, do this:
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // else, do this:
        return new ResponseEntity<>(tailNumber, HttpStatus.OK);
    }

    // for UPDATE method
    @PutMapping("{tailNumber}") // full access to url would be http://localhost:8080/api/v1/jets/1abc
    public ResponseEntity<String> updateJet(@PathVariable("tailNumber") String tailNumber, @RequestBody Jet newJetDetails) {
        jetService.updateJet(tailNumber, newJetDetails);
        return ResponseEntity.ok("in progress");
    }


}