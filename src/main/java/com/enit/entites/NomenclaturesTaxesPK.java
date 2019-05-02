package com.enit.entites;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NomenclaturesTaxesPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String ndp;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((ndp == null) ? 0 : ndp.hashCode());
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
		NomenclaturesTaxesPK other = (NomenclaturesTaxesPK) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (ndp == null) {
			if (other.ndp != null)
				return false;
		} else if (!ndp.equals(other.ndp))
			return false;
		return true;
	}
	

}
