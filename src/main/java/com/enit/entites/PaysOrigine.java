package com.enit.entites;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="PaysOrigine")
@Data
@AllArgsConstructor
public class PaysOrigine implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static long getSerialversionuid() {
	return serialVersionUID;
}
  @Id
  @NotNull
  @Size(min=2,max=20)
  private String nomPays ;
  private  double droitDouane;
}
