package MainDB;
import jcbcPack.jcbcMain;
import jpaDAO.filmDAO;
import jpaDAO.genreDAO;
import jpaDAO.realDAO;

public class DB_launch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//jcbcMain.main(args);
		
		System.out.println("DAO Film");
		filmDAO daoFilm = new filmDAO();
		daoFilm.AfficherFilms();
		System.out.println("----------------------");
		daoFilm.creerFilm("Un autre", 2024, 1, 1);
		daoFilm.AfficherFilms();
		System.out.println("----------------------");
		daoFilm.supprimerFilmParId(2);
		daoFilm.AfficherFilms();
		System.out.println("----------------------");
		daoFilm.modifierFilmParId(1, "Matrix 4", 2024, 1, 1);
		daoFilm.AfficherFilms();
		System.out.println("----------------------");
		daoFilm.modifierFilmParId(1, "Matrix", 1999, 1, 1);
		daoFilm.AfficherFilms();
		System.out.println("----------------------");
		
		System.out.println("DAO Genre");
		genreDAO daoGenre = new genreDAO();
		daoGenre.AfficherGenres();
		System.out.println("----------------------");
		daoGenre.creerGenre("Action");
		daoGenre.AfficherGenres();
		System.out.println("----------------------");
		daoGenre.supprimerGenreParId(2);
		daoGenre.AfficherGenres();
		System.out.println("----------------------");
		daoGenre.modifierGenreParId(1, "Fantaisie");
		daoGenre.AfficherGenres();
		System.out.println("----------------------");
		daoGenre.modifierGenreParId(1, "Science-fiction");
		daoGenre.AfficherGenres();
		System.out.println("----------------------");
		
		System.out.println("DAO Realisateur");
		realDAO daoReal = new realDAO();
		daoReal.AfficherRealisateurs();
		System.out.println("----------------------");
		daoReal.creerRealisateur("Nolan", "Christopher");
		daoReal.AfficherRealisateurs();
		System.out.println("----------------------");
		daoReal.supprimerRealisateurParId(2);
		daoReal.AfficherRealisateurs();
		System.out.println("----------------------");
		daoReal.modifierRealisateurParId(1, "Reeves", "Matt");
		daoReal.AfficherRealisateurs();
		System.out.println("----------------------");
		daoReal.modifierRealisateurParId(1, "Wachowski", "Lana");
		daoReal.AfficherRealisateurs();
		System.out.println("----------------------");
		
	}

}
