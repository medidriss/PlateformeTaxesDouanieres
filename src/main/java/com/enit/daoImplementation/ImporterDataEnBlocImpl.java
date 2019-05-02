package com.enit.daoImplementation;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enit.dao.ChapitreRepository;
import com.enit.dao.ImporterDataEnBloc;
import com.enit.dao.NomenclatureRepository;
import com.enit.dao.NomenclaturesTaxesRepository;
import com.enit.dao.TaxeRepository;
import com.enit.data.utils.ExcelUtils;
import com.enit.entites.Chapitre;
import com.enit.entites.Nomenclature;
import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.NomenclaturesTaxesPK;
import com.enit.entites.Taxe;
@Component
public class ImporterDataEnBlocImpl implements ImporterDataEnBloc {
    @Autowired
    private ChapitreRepository chapitreRepository;
    @Autowired 
    private NomenclaturesTaxesRepository nomenclaturesTaxesRepository;
    @Autowired 
    private NomenclatureRepository nomenclatureRepository;
    @Autowired 
    private TaxeRepository taxeRepository;
	@Override
	public void importerDataEnBloc(String numChapitre, String chapitreDesignation, String FILE_NAME, int[] positionsTaxes,
			String[] codesTaxes) {
		 try {
		Map<String, com.enit.entites.Taxe> taxes = com.enit.data.utils.TaxesDAO.getTaxes();
		Chapitre chapitre = new Chapitre(numChapitre, chapitreDesignation, codesTaxes, positionsTaxes,new ArrayList<>());
		 chapitreRepository.save(chapitre);
	
	            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();
	            while (iterator.hasNext()) {
        		Row currentRow = null;
	            	boolean ligne_ndp_trouvee = false;
	            	while(!ligne_ndp_trouvee && iterator.hasNext()) {
	            		currentRow = iterator.next();
		                String cle = ExcelUtils.getCellValueAsString(currentRow.getCell(6));
		                if(cle == null || cle.isEmpty()) {break;}
		                try {
		                	//System.out.println("essai d'une valeur de cl�");
							int cle_int = Integer.parseInt(cle);
							ligne_ndp_trouvee = true;
						} catch (NumberFormatException e) {
						}
	            	}
	                
	            	if(ligne_ndp_trouvee) {
	            		
	            		//System.out.println("ndp trouv�");
	            		StringBuilder sb_ndpValue = new StringBuilder();
		                sb_ndpValue.append(ExcelUtils.getCellValueAsString(currentRow.getCell(1)));//nsh
		                sb_ndpValue.append(ExcelUtils.getCellValueAsString(currentRow.getCell(2)));//ue
		                sb_ndpValue.append(ExcelUtils.getCellValueAsString(currentRow.getCell(3)));//ue
		                sb_ndpValue.append(ExcelUtils.getCellValueAsString(currentRow.getCell(4)));//tarif
		                sb_ndpValue.append(ExcelUtils.getCellValueAsString(currentRow.getCell(5)));//ngp
		                sb_ndpValue.append(ExcelUtils.getCellValueAsString(currentRow.getCell(6)));//ngp
		                
		                StringBuilder sb_designation = new StringBuilder();
		                //recherche ligne valeurs
		                boolean ligne_vals_trouvee = false;
		                while(!ligne_vals_trouvee) {
		                	sb_designation.append(ExcelUtils.getCellValueAsString(currentRow.getCell(7)));
		                	sb_designation.append(" ");
			                String val1 = ExcelUtils.getCellValueAsString(currentRow.getCell(positionsTaxes[0]));
			                if(val1!=null && !val1.isEmpty()) {
			                	ligne_vals_trouvee = true;
			                }else {
				                currentRow = iterator.next();			                	
			                }
		                }
		                if(ligne_vals_trouvee) {
		                	//vals trouvees et designation compl�t�e
			                String ndpValue = sb_ndpValue.toString();
			                String designation = sb_designation.toString();
			                String designationCorrection;
			                designationCorrection = designation.substring(0,designation.indexOf("*"));
			                
		            		Nomenclature ndp = new Nomenclature(ndpValue, designationCorrection, new ArrayList<>(),new ArrayList<>(), chapitre);
		            		
		            		 	
		                	for(int i=0;i<codesTaxes.length;i++) {
		                		Taxe t = taxes.get(codesTaxes[i]);
		                		String formule = t.getFormule();
		                		String val = ExcelUtils.getCellValueAsString(currentRow.getCell(positionsTaxes[i]));
		                		formule = formule.replaceFirst("t.", val);
		                		t.setFormule(formule);
		                		
		                	   NomenclaturesTaxesPK nomenclaturesTaxesPK = new NomenclaturesTaxesPK(t.getCode(),ndpValue);
		                	    NomenclaturesTaxes nomenclaturesTaxes = new NomenclaturesTaxes(nomenclaturesTaxesPK, ndp, t);
		                	   nomenclaturesTaxesRepository.save(nomenclaturesTaxes);
		                	     List<NomenclaturesTaxes> listeTaxes = ndp.getNomenclaturesTaxes();
		                	    listeTaxes.add(nomenclaturesTaxes);
		                	     ndp.setNomenclaturesTaxes(listeTaxes);
		                	     nomenclatureRepository.save(ndp);
		                	     taxeRepository.save(t);
		                	   
		        
		                	}
			                   
		                }


	            	}
	                	                
	            }
	              chapitre.setNomenclatures(nomenclatureRepository.findAll());
	              chapitreRepository.save(chapitre);
	           
	          
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	  
		
	}

	
	
}


