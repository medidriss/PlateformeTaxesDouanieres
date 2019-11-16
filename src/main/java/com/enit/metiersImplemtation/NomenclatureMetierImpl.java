package com.enit.metiersImplemtation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.enit.dao.NomenclatureRepository;
import com.enit.entites.Nomenclature;
import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.SimulationUnitaire;
import com.enit.metiers.NomenclatureMetier;

@Component
public class NomenclatureMetierImpl implements NomenclatureMetier {
    @Autowired
    private NomenclatureRepository nomenclatureRepository;

    @Override
    public Nomenclature consulterNomenclatureParNdp(String ndp) {
        return nomenclatureRepository.findById(ndp).get();

    }

    @Override
    public List<Nomenclature> consulterNomenclatureParGroupe(String numChapitre) {

        return null;
    }

    @Override
    public List<Nomenclature> consulterNomenclatureParMotCle(String mc) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Nomenclature> consulterTousNomenclatures() {
        return nomenclatureRepository.findAll();
    }

    @Override
    public boolean ajouterNomenclature(Nomenclature nomenclature) {
        try {
            nomenclatureRepository.save(nomenclature);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean supprimerNomenclature(String ndp) {
        try {
            Nomenclature n = nomenclatureRepository.findById(ndp).get();
            if (n != null) {
                nomenclatureRepository.delete(n);
                return true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean ajouterSimulationUnitaireNomenclature(String ndp, SimulationUnitaire simulationUnitaire) {
        try {
            if (!ndp.isEmpty()) {
                Nomenclature n = nomenclatureRepository.findById(ndp).get();

                if ((n != null) && (simulationUnitaire != null)) {
                    n.addSimulationUnitaire(simulationUnitaire);
                    nomenclatureRepository.save(n);
                    return true;


                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public Page<Nomenclature> pagesNomenclatures(int page, int size) {
        Page<Nomenclature> pages = nomenclatureRepository.findAll(new PageRequest(page, size));

        return pages;
    }

    @Override
    public void ajouterNomenclaturesTaxesNomenclature(String ndp, NomenclaturesTaxes nomenclaturesTaxes) {
        try {
            Nomenclature n = consulterNomenclatureParNdp(ndp);
            List<NomenclaturesTaxes> list = n.getNomenclaturesTaxes();
            list.add(nomenclaturesTaxes);
            n.setNomenclaturesTaxes(list);
            ajouterNomenclature(n);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
