
package db;

public class Type {
    private int idType;
    private String nomType;
    private Categorie cat;

    public Type(int idType, String nomType, Categorie cat) {
        this.idType = idType;
        this.nomType = nomType;
        this.cat = cat;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public Categorie getCat() {
        return cat;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Type{" +
                "idType=" + idType +
                ", nomType='" + nomType + '\'' +
                ", cat=" + cat +
                '}';
    }
}


