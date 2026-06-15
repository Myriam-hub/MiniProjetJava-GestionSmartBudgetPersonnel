import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("GESTIONNAIRE DE BUDGET PERSONNEL");
        System.out.println("=================================");

        System.out.println("1. Nouveau profil");
        System.out.println("2. Charger un profil existant");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();
        sc.nextLine();

        Utilisateur utilisateur;

        if (choix == 1) {

            System.out.println("\n===== CREATION DU PROFIL =====");

            System.out.print("Nom : ");
            String nom = sc.nextLine();

            System.out.print("Prénom : ");
            String prenom = sc.nextLine();

            System.out.print("Profession : ");
            String profession = sc.nextLine();

            System.out.print("Salaire mensuel : ");
            double salaire = sc.nextDouble();

            utilisateur = new Utilisateur(
                    nom,
                    prenom,
                    profession,
                    salaire
            );

            GestionFichier.sauvegarderProfil(utilisateur);

        } else {

            utilisateur = GestionFichier.chargerProfil();

            if (utilisateur == null) {
                System.out.println("Aucun profil trouvé.");
                return;
            }
        }

        System.out.println("\n===== PROFIL UTILISATEUR =====");
        System.out.println("Nom : " + utilisateur.getNom());
        System.out.println("Prénom : " + utilisateur.getPrenom());
        System.out.println("Profession : " + utilisateur.getProfession());
        System.out.println("Salaire : "
                + utilisateur.getSalaireMensuel()
                + " FCFA");

        System.out.println("\n===== SAISIE DES DEPENSES =====");

        System.out.print("Loyer : ");
        double loyer = sc.nextDouble();

        System.out.print("Transport : ");
        double transport = sc.nextDouble();

        System.out.print("Nourriture : ");
        double nourriture = sc.nextDouble();

        System.out.print("Eau et Electricité : ");
        double eauElectricite = sc.nextDouble();

        System.out.print("Téléphone / Internet : ");
        double telephoneInternet = sc.nextDouble();

        System.out.print("Santé : ");
        double sante = sc.nextDouble();

        System.out.print("Loisirs : ");
        double loisirs = sc.nextDouble();

        Budget budget = new Budget(
                loyer,
                transport,
                nourriture,
                eauElectricite,
                telephoneInternet,
                sante,
                loisirs
        );

        AnalyseBudget analyse =
                new AnalyseBudget(utilisateur, budget);

        System.out.println("\n===== ANALYSE BUDGETAIRE =====");

        System.out.println("Total des dépenses : "
                + budget.calculerTotalDepenses()
                + " FCFA");

        System.out.println("Dépenses essentielles : "
                + analyse.calculerDepensesEssentielles()
                + " FCFA");

        System.out.println("Dépenses de confort : "
                + analyse.calculerDepensesConfort()
                + " FCFA");

        System.out.println("Montant restant : "
                + analyse.calculerMontantRestant()
                + " FCFA");

        System.out.printf("Taux d'épargne : %.2f %%\n",
                analyse.calculerTauxEpargne());

        System.out.println("Diagnostic : "
                + analyse.diagnosticBudget());

        System.out.println("\n===== ANALYSE DES DEPENSES =====");

        System.out.println("Plus grande dépense : "
                + analyse.plusGrandeDepense());

        System.out.println("Plus petite dépense : "
                + analyse.plusPetiteDepense());

        analyse.classementDepenses();

        System.out.println("\n===== PROJECTION FINANCIERE =====");

        double epargneMensuelle =
                analyse.calculerMontantRestant();

        double epargneAnnuelle =
                epargneMensuelle * 12;

        System.out.println(
                "Epargne annuelle potentielle : "
                        + epargneAnnuelle
                        + " FCFA"
        );

        sc.nextLine();

        System.out.print("Nom de votre objectif : ");
        String objectif = sc.nextLine();

        System.out.print("Montant de l'objectif : ");
        double montantObjectif = sc.nextDouble();

        if (epargneMensuelle > 0) {

            double mois =
                    Math.ceil(
                            montantObjectif
                                    / epargneMensuelle
                    );

            System.out.println("Objectif : "
                    + objectif);

            System.out.println(
                    "Nombre de mois nécessaires : "
                            + (int) mois
            );

        } else {

            System.out.println(
                    "Aucune capacité d'épargne disponible."
            );
        }

        System.out.println("\n===== RAPPORT FINAL =====");

        System.out.println(
                "Utilisateur : "
                        + utilisateur.getPrenom()
                        + " "
                        + utilisateur.getNom()
        );

        System.out.println(
                "Profession : "
                        + utilisateur.getProfession()
        );

        System.out.println(
                "Salaire : "
                        + utilisateur.getSalaireMensuel()
                        + " FCFA"
        );

        System.out.println(
                "Total dépenses : "
                        + budget.calculerTotalDepenses()
                        + " FCFA"
        );

        System.out.println(
                "Montant restant : "
                        + analyse.calculerMontantRestant()
                        + " FCFA"
        );

        System.out.printf(
                "Taux d'épargne : %.2f %%\n",
                analyse.calculerTauxEpargne()
        );

        System.out.println(
                "Diagnostic : "
                        + analyse.diagnosticBudget()
        );

        if (analyse.calculerTauxEpargne() >= 30) {

            System.out.println(
                    "Recommandation : Continuez vos efforts d'épargne."
            );

        } else if (analyse.calculerTauxEpargne() >= 15) {

            System.out.println(
                    "Recommandation : Votre budget est correct mais peut être optimisé."
            );

        } else {

            System.out.println(
                    "Recommandation : Réduisez les dépenses non essentielles."
            );
        }

        System.out.println(
                "\nMerci d'avoir utilisé le Gestionnaire de Budget Personnel."
        );

        sc.close();
    }
}