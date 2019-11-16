package com.enit.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ImporterDataEnBloc {
    public void importerDataEnBloc(String numChapitre, String chapitreDesignation, String FILE_NAME, int[] positionsTaxes,
                                   String[] codesTaxes);

}
