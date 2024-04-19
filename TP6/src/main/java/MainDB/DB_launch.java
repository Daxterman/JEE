package MainDB;
import jcbcPack.jcbcMain;
import jpaDAO.filmDAO;

public class DB_launch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//jcbcMain.main(args);
		filmDAO daoFilm = new filmDAO();
		daoFilm.AfficherFilms();
	}

}
