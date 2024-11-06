
package db;


public class Categorie {
    private int IdCat;
  private String NomCat;
public Categorie(int idCat, String NomCat){
    this.IdCat=idCat; 
}
public int getIdCat(){
    return IdCat;
}
public void setIdCat(int idCat){
    this.IdCat=idCat;
}
public String getNomCat(){
    return NomCat;
}
public void setNomCat(String NomCat){
    this.NomCat=NomCat;
}

}



