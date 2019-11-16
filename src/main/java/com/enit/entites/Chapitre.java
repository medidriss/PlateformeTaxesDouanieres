package com.enit.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document(collection = "Chapitre")
@NoArgsConstructor
public class Chapitre implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String numChapitre;
    private String designation;
    private String codesTaxes[];
    private int positionTaxes[];
    private List<Nomenclature> nomenclatures;

    public Chapitre(String numChapitre, String designation, String[] codesTaxes, int[] positionTaxes,
                    Nomenclature nomenclature) {
        super();

        this.numChapitre = numChapitre;
        this.designation = designation;
        this.codesTaxes = codesTaxes;
        this.positionTaxes = positionTaxes;
        this.nomenclatures.add(nomenclature);
    }

    public Chapitre(String numChapitre, String designation, String[] codesTaxes, int[] positionTaxes,
                    List<Nomenclature> nomenclatures) {
        super();
        this.nomenclatures = new ArrayList<>();
        this.numChapitre = numChapitre;
        this.designation = designation;
        this.codesTaxes = codesTaxes;
        this.positionTaxes = positionTaxes;
        this.nomenclatures = nomenclatures;
    }

    public void addNomenclature(Nomenclature nomenclature) {
        if (nomenclature != null) {
            if (!nomenclatures.contains(nomenclature)) {
                nomenclatures.add(nomenclature);
            } else {
                nomenclatures.remove(nomenclature);
                nomenclatures.add(nomenclature);
            }
        }
    }

    public String getNumChapitre() {
        return numChapitre;
    }

    public void setNumChapitre(String numChapitre) {
        this.numChapitre = numChapitre;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String[] getCodesTaxes() {
        return codesTaxes;
    }

    public void setCodesTaxes(String[] codesTaxes) {
        this.codesTaxes = codesTaxes;
    }

    public int[] getPositionTaxes() {
        return positionTaxes;
    }

    public void setPositionTaxes(int[] positionTaxes) {
        this.positionTaxes = positionTaxes;
    }

    public List<Nomenclature> getNomenclatures() {
        return nomenclatures;
    }

    public void setNomenclatures(List<Nomenclature> nomenclatures) {
        this.nomenclatures = nomenclatures;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((designation == null) ? 0 : designation.hashCode());
        result = prime * result + ((numChapitre == null) ? 0 : numChapitre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Chapitre other = (Chapitre) obj;
        if (designation == null) {
            if (other.designation != null)
                return false;
        } else if (!designation.equals(other.designation))
            return false;
        if (numChapitre == null) {
            if (other.numChapitre != null)
                return false;
        } else if (!numChapitre.equals(other.numChapitre))
            return false;
        return true;
    }


}
