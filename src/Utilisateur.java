public class Utilisateur {

    private String nom;
    private String prenom;
    private String profession;
    private double salaireMensuel;

    public Utilisateur(String nom, String prenom, String profession, double salaireMensuel) {
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.salaireMensuel = salaireMensuel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getProfession() {
        return profession;
    }

    public double getSalaireMensuel() {
        return salaireMensuel;
    }
}