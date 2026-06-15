/**
 * Classe AnalyseBudget
 * Effectue les calculs et analyses du budget.
 */
public class AnalyseBudget {

    private Utilisateur utilisateur;
    private Budget budget;

    /**
     * Constructeur
     */
    public AnalyseBudget(Utilisateur utilisateur, Budget budget) {
        this.utilisateur = utilisateur;
        this.budget = budget;
    }

    /**
     * Calcule le montant restant après les dépenses.
     */
    public double calculerMontantRestant() {
        return utilisateur.getSalaireMensuel()
                - budget.calculerTotalDepenses();
    }

    /**
     * Calcule les dépenses essentielles.
     */
    public double calculerDepensesEssentielles() {
        return budget.getLoyer()
                + budget.getTransport()
                + budget.getNourriture()
                + budget.getEauElectricite()
                + budget.getTelephoneInternet()
                + budget.getSante();
    }

    /**
     * Calcule les dépenses de confort.
     */
    public double calculerDepensesConfort() {
        return budget.getLoisirs();
    }

    /**
     * Calcule le taux d'épargne.
     */
    public double calculerTauxEpargne() {

        double restant = calculerMontantRestant();

        return (restant / utilisateur.getSalaireMensuel()) * 100;
    }

    /**
     * Établit un diagnostic du budget.
     */
    public String diagnosticBudget() {

        double taux = calculerTauxEpargne();

        if (taux >= 30) {
            return "Budget excellent";
        } else if (taux >= 15) {
            return "Budget acceptable";
        } else if (taux > 0) {
            return "Budget à surveiller";
        } else {
            return "Dépenses supérieures aux revenus";
        }
    }
    /**
 * Retourne la plus grande dépense.
 */
public String plusGrandeDepense() {

    double[] montants = {
            budget.getLoyer(),
            budget.getTransport(),
            budget.getNourriture(),
            budget.getEauElectricite(),
            budget.getTelephoneInternet(),
            budget.getSante(),
            budget.getLoisirs()
    };

    String[] categories = {
            "Loyer",
            "Transport",
            "Nourriture",
            "Eau et Electricite",
            "Telephone / Internet",
            "Sante",
            "Loisirs"
    };

    double max = montants[0];
    int indice = 0;

    for (int i = 1; i < montants.length; i++) {

        if (montants[i] > max) {
            max = montants[i];
            indice = i;
        }
    }

    return categories[indice] + " (" + max + " FCFA)";
}
/**
 * Retourne la plus petite dépense.
 */
public String plusPetiteDepense() {

    double[] montants = {
            budget.getLoyer(),
            budget.getTransport(),
            budget.getNourriture(),
            budget.getEauElectricite(),
            budget.getTelephoneInternet(),
            budget.getSante(),
            budget.getLoisirs()
    };

    String[] categories = {
            "Loyer",
            "Transport",
            "Nourriture",
            "Eau et Electricite",
            "Telephone / Internet",
            "Sante",
            "Loisirs"
    };

    double min = montants[0];
    int indice = 0;

    for (int i = 1; i < montants.length; i++) {

        if (montants[i] < min) {
            min = montants[i];
            indice = i;
        }
    }

    return categories[indice] + " (" + min + " FCFA)";
}

public void classementDepenses() {

    String[] categories = {
            "Loyer",
            "Transport",
            "Nourriture",
            "Eau et Electricite",
            "Telephone / Internet",
            "Sante",
            "Loisirs"
    };

    double[] montants = {
            budget.getLoyer(),
            budget.getTransport(),
            budget.getNourriture(),
            budget.getEauElectricite(),
            budget.getTelephoneInternet(),
            budget.getSante(),
            budget.getLoisirs()
    };

    for (int i = 0; i < montants.length - 1; i++) {

        for (int j = i + 1; j < montants.length; j++) {

            if (montants[j] > montants[i]) {

                double tempMontant = montants[i];
                montants[i] = montants[j];
                montants[j] = tempMontant;

                String tempCategorie = categories[i];
                categories[i] = categories[j];
                categories[j] = tempCategorie;
            }
        }
    }

    System.out.println("\n===== CLASSEMENT DES DEPENSES =====");

    for (int i = 0; i < montants.length; i++) {

        System.out.println(
                (i + 1) + ". "
                        + categories[i]
                        + " : "
                        + montants[i]
                        + " FCFA"
        );
    }
}
}
