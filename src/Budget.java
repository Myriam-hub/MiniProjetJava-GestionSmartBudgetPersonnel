/**
 * Classe Budget
 * Permet de stocker toutes les dépenses mensuelles de l'utilisateur.
 */
public class Budget {

    // Déclaration des attributs
    private double loyer;
    private double transport;
    private double nourriture;
    private double eauElectricite;
    private double telephoneInternet;
    private double sante;
    private double loisirs;

    /**
     * Constructeur de la classe Budget
     * Initialise toutes les dépenses mensuelles.
     */
    public Budget(double loyer,
                  double transport,
                  double nourriture,
                  double eauElectricite,
                  double telephoneInternet,
                  double sante,
                  double loisirs) {

        this.loyer = loyer;
        this.transport = transport;
        this.nourriture = nourriture;
        this.eauElectricite = eauElectricite;
        this.telephoneInternet = telephoneInternet;
        this.sante = sante;
        this.loisirs = loisirs;
    }

    // Getters permettant de récupérer les valeurs des dépenses

    public double getLoyer() {
        return loyer;
    }

    public double getTransport() {
        return transport;
    }

    public double getNourriture() {
        return nourriture;
    }

    public double getEauElectricite() {
        return eauElectricite;
    }

    public double getTelephoneInternet() {
        return telephoneInternet;
    }

    public double getSante() {
        return sante;
    }

    public double getLoisirs() {
        return loisirs;
    }

    /**
     * Calcule le total des dépenses mensuelles.
     *
     * @return total des dépenses
     */
    public double calculerTotalDepenses() {

        return loyer
                + transport
                + nourriture
                + eauElectricite
                + telephoneInternet
                + sante
                + loisirs;
    }
}