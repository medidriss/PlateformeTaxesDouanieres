package com.enit.entites;

import java.io.Serializable;

import org.springframework.context.annotation.EnableMBeanExport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SimulationUnitaireKey implements Serializable {
    public String getNdp() {
        return ndp;
    }

    public void setNdp(String ndp) {
        this.ndp = ndp;
    }

    public String getIdSimulation() {
        return idSimulation;
    }

    public void setIdSimulation(String idSimulation) {
        this.idSimulation = idSimulation;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String ndp;
    private String idSimulation;


}
