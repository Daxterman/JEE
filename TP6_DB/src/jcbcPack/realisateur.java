package jcbcPack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="realisateur")
public class realisateur {
    @Id
    private String nom_real;
    private String prenom_real;
    
    public realisateur() {}
    
    public String getnom_real()
    {
    	return this.nom_real;
    }
    
    public void setnom_real(String nom)
    {
    	this.nom_real = nom;
    }
    
    public String getprenom_real()
    {
    	return this.prenom_real;
    }
    
    public void setprenom_real(String pre)
    {
    	this.prenom_real = pre;
    }
    
    @Override
    public String toString() {
        return "Real{" +
               "nomReal='" + nom_real + '\'' +
               ", prenomReal='" + prenom_real + '\'' +
               '}';
    }
    

}
