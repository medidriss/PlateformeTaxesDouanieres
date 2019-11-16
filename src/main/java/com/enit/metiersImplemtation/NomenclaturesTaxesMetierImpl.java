package com.enit.metiersImplemtation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enit.dao.NomenclaturesTaxesRepository;
import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.NomenclaturesTaxesPK;
import com.enit.metiers.NomenclaturesTaxesMetier;

@Component
public class NomenclaturesTaxesMetierImpl implements NomenclaturesTaxesMetier {
    @Autowired
    private NomenclaturesTaxesRepository nomenclaturesTaxesRepository;

    @Override
    public boolean ajouterNomenclaturesTaxes(NomenclaturesTaxes nomenclaturesTaxes) {
        try {
            if (nomenclaturesTaxes != null) {
                nomenclaturesTaxesRepository.save(nomenclaturesTaxes);
                return true;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean supprimerNomenclaturesTaxes(NomenclaturesTaxesPK nomenclaturesTaxesPK) {
        try {
            NomenclaturesTaxes nomenclaturesTaxes = consulterNomenclaturesTaxes(nomenclaturesTaxesPK);
            if (nomenclaturesTaxes != null) {
                nomenclaturesTaxesRepository.delete(nomenclaturesTaxes);
                return true;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean modifierNomenclaturesTaxes(NomenclaturesTaxesPK nomenclaturesTaxesPK,
                                              NomenclaturesTaxes nomenclaturesTaxes) {
        try {
            NomenclaturesTaxes nomenclaturesTaxes2 = consulterNomenclaturesTaxes(nomenclaturesTaxesPK);
            if (nomenclaturesTaxes != null && nomenclaturesTaxes2 != null) {
                nomenclaturesTaxes2.setId(nomenclaturesTaxes.getId());
                nomenclaturesTaxes2.setNomenclature(nomenclaturesTaxes.getNomenclature());
                nomenclaturesTaxes2.setTaxe(nomenclaturesTaxes.getTaxe());
                nomenclaturesTaxesRepository.save(nomenclaturesTaxes2);
                return true;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public NomenclaturesTaxes consulterNomenclaturesTaxes(NomenclaturesTaxesPK nomenclaturesTaxesPK) {
        try {
            NomenclaturesTaxes nomenclaturesTaxes = nomenclaturesTaxesRepository.findById(nomenclaturesTaxesPK).get();
            if (nomenclaturesTaxes != null) {
                return nomenclaturesTaxes;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<NomenclaturesTaxes> consulterlisteNomenlaturesTaxesParNdp(String ndp) {
        try {
            return nomenclaturesTaxesRepository.listeNomenclaturesTaxesParNdp(ndp);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<NomenclaturesTaxes> consulterlisteNomenlaturesTaxesParTaxe(String code) {
        try {
            return nomenclaturesTaxesRepository.listeNomenclaturesTaxesParTaxe(code);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }


}
