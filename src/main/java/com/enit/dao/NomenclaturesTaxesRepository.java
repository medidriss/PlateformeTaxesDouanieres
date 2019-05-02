package com.enit.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.NomenclaturesTaxesPK;

public interface NomenclaturesTaxesRepository extends MongoRepository<NomenclaturesTaxes,NomenclaturesTaxesPK> {
	@Query("{ 'id.ndp' : ?0 }")
	public List<NomenclaturesTaxes> listeNomenclaturesTaxesParNdp(@Param(value="ndp") String ndp);
	@Query("{ 'id.code' : ?0 }")
	public List<NomenclaturesTaxes> listeNomenclaturesTaxesParTaxe(@Param(value="code") String code);
}
