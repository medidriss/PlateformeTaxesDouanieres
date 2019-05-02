package com.enit.metiers;

import java.util.List;

import com.enit.entites.Chapitre;
import com.enit.entites.Nomenclature;

public interface ChapitreMetier {
    public Chapitre consulterChapitre(String numChapitre);
    public List<Chapitre> listerChapitre();
    public void importerDataEnBloc(String numChapitre, String chapitreDesignation, String FILE_NAME, int[] positionsTaxes,String[] codesTaxes);
    public boolean supprimerChapitre(String numChapitre);
    public boolean modifierChapitre(String numChapitre, Chapitre chapitre);
    public boolean ajouterChapitre(Chapitre chapitre);
    public boolean ajouterNomenclatureAChapitre(String numChapitre,Nomenclature nomenclature);
    public boolean supprimerNomenclatureDeChapitre(String numChapitre,Nomenclature nomenclature);
    

}

