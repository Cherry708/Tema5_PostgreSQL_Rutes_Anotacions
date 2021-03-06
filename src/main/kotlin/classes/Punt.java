package classes;

import javax.persistence.*;

@Entity
@IdClass(PuntPK.class)
public class Punt {
    private int numR;
    private int numP;
    private String nomP;
    private Float latitud;
    private Float longitud;
    private Ruta ruta;

    @Id
    @Column(name = "num_r")
    public int getNumR() {
        return numR;
    }

    public void setNumR(int numR) {
        this.numR = numR;
    }

    @Id
    @Column(name = "num_p")
    public int getNumP() {
        return numP;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }

    @Basic
    @Column(name = "nom_p")
    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    @Basic
    @Column(name = "latitud")
    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    @Basic
    @Column(name = "longitud")
    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Punt punt = (Punt) o;

        if (numR != punt.numR) return false;
        if (numP != punt.numP) return false;
        if (nomP != null ? !nomP.equals(punt.nomP) : punt.nomP != null) return false;
        if (latitud != null ? !latitud.equals(punt.latitud) : punt.latitud != null) return false;
        if (longitud != null ? !longitud.equals(punt.longitud) : punt.longitud != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numR;
        result = 31 * result + numP;
        result = 31 * result + (nomP != null ? nomP.hashCode() : 0);
        result = 31 * result + (latitud != null ? latitud.hashCode() : 0);
        result = 31 * result + (longitud != null ? longitud.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "num_r", referencedColumnName = "num_r", nullable = false, insertable = false, updatable = false)
    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
