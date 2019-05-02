package com.enit.metiers;

import java.util.List;

import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.NomenclaturesTaxesPK;

public interface NomenclaturesTaxesMetier {
	public boolean ajouterNomenclaturesTaxes(NomenclaturesTaxes nomenclaturesTaxes);
	public boolean supprimerNomenclaturesTaxes(NomenclaturesTaxesPK nomenclaturesTaxesPK);
	public boolean modifierNomenclaturesTaxes(NomenclaturesTaxesPK nomenclaturesTaxesPK,NomenclaturesTaxes nomenclaturesTaxes);
	public NomenclaturesTaxes consulterNomenclaturesTaxes(NomenclaturesTaxesPK nomenclaturesTaxesPK);
	public List<NomenclaturesTaxes> consulterlisteNomenlaturesTaxesParNdp(String ndp);
	public List<NomenclaturesTaxes> consulterlisteNomenlaturesTaxesParTaxe(String code);
	

}
