package com.enit.entites;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "NomenclaturesTaxes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NomenclaturesTaxes implements Serializable {
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private NomenclaturesTaxesPK id;
    @DBRef
    private Nomenclature nomenclature;
    @DBRef
    private Taxe taxe;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        NomenclaturesTaxes other = (NomenclaturesTaxes) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
