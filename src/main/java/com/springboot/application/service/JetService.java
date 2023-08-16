package com.springboot.application.service;
import com.springboot.application.model.Jet;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class JetService {

    private final List<Jet> jets = new ArrayList<>();

    public List<Jet> getJets() {
        return jets;
    }

    public void createJet(String tailNum, int wheelsNum, int length, String fuel) {
        Jet myJet = new Jet(tailNum, wheelsNum, length, fuel);
        jets.add(myJet);
    }

    public boolean deleteJet(String tailNumber) {
        var isRemoved = jets.removeIf(jet -> jet.getTailNumber().equals(tailNumber));
        return isRemoved;
    }

    public void updateJet(String tailNumber, Jet newJetDetails) {

        for (Jet jet : jets) {
            if (jet.getTailNumber().equals(tailNumber)) {

                jet.setTailNumber(newJetDetails.getTailNumber());
                jet.setNumberOfWheels(newJetDetails.getNumberOfWheels());
                jet.setLength(newJetDetails.getLength());
                jet.setFuel(newJetDetails.getFuel());
            }
        }
    }

}