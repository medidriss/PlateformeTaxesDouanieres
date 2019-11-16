package com.enit.models;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.enit.entites.Chapitre;
import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.SimulationUnitaire;
import com.enit.entites.Taxe;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NomenclatureModel {
    @NotEmpty
    @NotNull
    @Size(min = 11, max = 11, message = "NDP contient 11 chiffres")
    private String ndp;
    private String designation;

    private List<NomenclaturesTaxes> nomenclaturesTaxes;
    private List<SimulationUnitaire> simulationsUnitaires;
    private Chapitre chapitre;
    private List<Taxe> taxesPossibles;

}
