package fr.eni.trocenchere.bll;

import java.time.LocalDate;

import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.dal.DAOFactory;
import fr.eni.trocenchere.dal.EncherirDAO;
import fr.eni.trocenchere.dal.jdbc.EncherirDAOJdbcImpl;



public class EnchereManager {
	//Singleton
	private static EnchereManager instance;
	public static EnchereManager getInstance() {
		if(instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}
	
	private EnchereManager() {
		
	}
	//Fin singleton
	
	public Enchere insert(LocalDate dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
	    Enchere nouvelleEnchere = new Enchere(dateEnchere, montantEnchere, noArticle, noUtilisateur);

	    EncherirDAO enchereDAO = new EncherirDAOJdbcImpl();
	    enchereDAO.insert(nouvelleEnchere);

	    return nouvelleEnchere;
	}

	public Enchere getEnchereByNo(int noArticle) {
		EncherirDAO encherirDAO = DAOFactory.getEnchereDAO();
		return encherirDAO.SelectEnchereByNo(noArticle); 
	}
}
