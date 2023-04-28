package entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;


@ApiModel(description = "Entité Enregistrée dans Swagger")
public class Etudiant {
    private String cin;
    private String nom;
    private String prenom;

    public Etudiant(String cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }
    @ApiModelProperty(value = "unique CIN")
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @ApiModelProperty(value = "Nom de l etudiant")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @ApiModelProperty(value = "Prenom de l etudiant")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return cin == etudiant.cin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cin, nom, prenom);
    }
}
