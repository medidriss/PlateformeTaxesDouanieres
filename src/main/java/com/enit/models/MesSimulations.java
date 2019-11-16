package com.enit.models;

import java.util.ArrayList;
import java.util.List;

import com.enit.entites.Simulation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MesSimulations {

    List<Simulation> mesSimulations = new ArrayList<>();
}
