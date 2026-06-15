import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Classe permettant de sauvegarder
 * et charger un profil utilisateur.
 */
public class GestionFichier {

    /**
     * Sauvegarde les informations
     * de l'utilisateur dans un fichier texte.
     */
    public static void sauvegarderProfil(Utilisateur utilisateur) {

        try {

            FileWriter writer = new FileWriter("profil.txt");

            writer.write(utilisateur.getNom() + "\n");
            writer.write(utilisateur.getPrenom() + "\n");
            writer.write(utilisateur.getProfession() + "\n");
            writer.write(utilisateur.getSalaireMensuel() + "\n");

            writer.close();

            System.out.println("Profil sauvegardé avec succès.");

        } catch (Exception e) {

            System.out.println("Erreur lors de la sauvegarde du profil.");
        }
    }

    /**
     * Charge un profil utilisateur
     * depuis le fichier profil.txt.
     */
    public static Utilisateur chargerProfil() {

        try {

            File fichier = new File("profil.txt");

            Scanner lecteur = new Scanner(fichier);

            String nom = lecteur.nextLine();
            String prenom = lecteur.nextLine();
            String profession = lecteur.nextLine();
            double salaire =
                    Double.parseDouble(lecteur.nextLine());

            lecteur.close();

            System.out.println("Profil chargé avec succès.");

            return new Utilisateur(
                    nom,
                    prenom,
                    profession,
                    salaire
            );

        } catch (Exception e) {

            System.out.println("Aucun profil trouvé.");

            return null;
        }
    }
}