package com.enit.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.enit.entites.Nomenclature;
import com.enit.entites.Simulation;
import com.enit.entites.SimulationUnitaire;
import com.enit.entites.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimulationModel {
    private String rechercheNDP;
    private String rechercheMotCle;
    private Simulation simulation;
    private HashMap<String, String> designations = new HashMap<>();

    public void addDesignation(String ndp, String designation) {
        designations.put(ndp, designation);

    }

    List<SimulationUnitaire> listeSimulationUnitaire = new ArrayList<>();

}
