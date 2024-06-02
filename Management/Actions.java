package Management;

public class Actions {

    private static String[] actionsList = { "Liste-Etudiant", "Ajouter-Etudiant", "supprimer-Etudiant",
            "Ajouter-notes", "Notes-Etudiant", "Quitter" };

    public static void actions() {
        int i = 1;
        for (String action : actionsList) {
            if (i == actionsList.length)
                System.out.println("Autre touche pour " + action);
            else
                System.out.println(i + " : " + action);
            i++;
        }
    }
}
