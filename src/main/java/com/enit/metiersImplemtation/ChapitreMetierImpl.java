package com.enit.metiersImplemtation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enit.dao.ChapitreRepository;
import com.enit.dao.ImporterDataEnBloc;
import com.enit.data.utils.ExcelUtils;
import com.enit.entites.Chapitre;
import com.enit.entites.Nomenclature;
import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.NomenclaturesTaxesPK;
import com.enit.entites.Taxe;
import com.enit.metiers.ChapitreMetier;
import com.enit.metiers.NomenclatureMetier;
import com.enit.metiers.NomenclaturesTaxesMetier;
import com.enit.metiers.TaxeMetier;

@Component
public class ChapitreMetierImpl implements ChapitreMetier {
    private final String NDP = "42010000017";
    private final String FILE_NAME = "C:\\Users\\lenovo\\Desktop\\Cour\\PFA2\\PFA DOC\\DOC CHAPITRES/Ch42.xlsx";

    //CHAP 42
    private final int pos_taxes[] = {9, 12, 13, 16};
    private final String codes_taxes[] = {"001", "093", "105", "480"};

    @Autowired
    private ImporterDataEnBloc importerDataEnBloc;
    @Autowired
    private ChapitreRepository chapitreRepository;

    @Override
    public Chapitre consulterChapitre(String numChapitre) {
        try {
            Chapitre chapitre = chapitreRepository.findById(numChapitre).get();

            if (chapitre != null) {
                return chapitre;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Chapitre> listerChapitre() {
        return chapitreRepository.findAll();
    }


    @Override
    public boolean supprimerChapitre(String numChapitre) {
        try {
            Chapitre chapitre = chapitreRepository.findById(numChapitre).get();
            if (chapitre != null) {
                chapitreRepository.deleteById(numChapitre);
                return true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean modifierChapitre(String numChapitre, Chapitre chapitre) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean ajouterChapitre(Chapitre chapitre) {
        try {
            if (chapitre != null) {
                chapitreRepository.save(chapitre);
                return true;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean ajouterNomenclatureAChapitre(String numChapitre, Nomenclature nomenclature) {
        try {

            Chapitre chapitre = consulterChapitre(numChapitre);
            if (nomenclature != null && chapitre != null) {
                chapitre.addNomenclature(nomenclature);
                supprimerChapitre(numChapitre);
                ajouterChapitre(chapitre);
                return true;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    @Override
    public boolean supprimerNomenclatureDeChapitre(String numChapitre, Nomenclature nomenclature) {
        try {

            Chapitre chapitre = consulterChapitre(numChapitre);
            if (nomenclature != null && chapitre != null) {
                List<Nomenclature> liste = chapitre.getNomenclatures();
                liste.remove(nomenclature);
                chapitre.setNomenclatures(liste);
                chapitreRepository.save(chapitre);
                return true;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;

    }


    @Override
    public void importerDataEnBloc(java.lang.String numChapitre, java.lang.String chapitreDesignation,
                                   java.lang.String FILE_NAME, int[] positionsTaxes, java.lang.String[] codesTaxes) {
        importerDataEnBloc.importerDataEnBloc(numChapitre, chapitreDesignation, FILE_NAME, positionsTaxes, codesTaxes);

    }

}
