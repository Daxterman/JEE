package MainDB;
import jcbcPack.jcbcMain;
import jpaDAO.filmDAO;

public class DB_launch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//jcbcMain.main(args);
		filmDAO daoFilm = new filmDAO();
		daoFilm.AfficherFilms();
		System.out.println("----------------------");
		daoFilm.creerFilm("Un autre", 2024, "Science-fiction", "Wachowski");
		daoFilm.AfficherFilms();
		System.out.println("----------------------");
		daoFilm.supprimerFilmParNom("Un autre");
		daoFilm.AfficherFilms();
		System.out.println("----------------------");
		daoFilm.modifierFilmParId(1, "Matrix 4", 2024, "Science-fiction", "Wachowski");
		daoFilm.AfficherFilms();
		System.out.println("----------------------");
		daoFilm.modifierFilmParId(1, "Matrix", 1999, "Science-fiction", "Wachowski");
		daoFilm.AfficherFilms();
		
	}

}
