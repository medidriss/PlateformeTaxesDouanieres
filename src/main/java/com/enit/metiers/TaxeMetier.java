package com.enit.metiers;

import java.util.List;

import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.Taxe;

public interface TaxeMetier {
    public Taxe consulterTaxe(String code);

    public List<Taxe> listerTaxes();

    public boolean ajouterTaxe(Taxe taxe);

    public boolean supprimerTaxe(String code);

    public boolean modifierTaxe(String code, Taxe taxe);

}
