package Management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Etudiants {

    protected int id;
    protected String lastName;
    protected String firstName;
    protected int age;

    protected static HashMap<String, Double> notes = new HashMap<>();

    protected HashMap<String, Double> studentNots = new HashMap<>();

    protected static ArrayList<Etudiants> etudiants = new ArrayList<Etudiants>();

    public Etudiants() {
    }

    public Etudiants(int id, String nom, String prenom, int age) {
        this.id = id;
        this.lastName = nom;
        this.firstName = prenom;
        this.age = age;
    }

    public void addStudent(Etudiants etudiant) {

        Etudiants.etudiants.add(etudiant);
        System.out.println("Etudiant ajoute avec succes");

    }

    public static void deleteStudent(int id) {
        for (Etudiants etudiant : Etudiants.etudiants) {
            if (etudiant.getId() == id) {
                Etudiants.etudiants.remove(id);
            }
        }
    }

    public void addNotes() {
        String[] matieres = { "Francais", "Maths", "PC" };

        Scanner sc = new Scanner(System.in);
        System.out.print("Identifiant de l'Etudiant : ");
        while (!sc.hasNextInt()) {
            System.out.print("Incorrect . Reeassayer : ");
            sc.next();
        }

        int id = sc.nextInt();

        for (Etudiants etudiant : etudiants) {
            if (etudiant.id == id) {

                for (String matiere : matieres) {
                    System.out.print("Entrez la note de " + matiere + " : ");
                    while (!sc.hasNextDouble()) {
                        System.out.print("Entrez un nombre : ");
                        sc.next();
                    }

                    Double note = sc.nextDouble();
                    while (note < 0 || note > 20) {
                        System.out.println("Entrez un nombre entre 0 et 20");
                    }

                    this.studentNots.put(matiere, note);
                }
            }
        }

        System.out.println("Notes ajoutees avec succes");

    }

    public void viewEtudiantNotes() {
        if (this.studentNots.isEmpty()) {
            System.out.println("Aucune note pour cet etudiant");
        } else {

            for (Map.Entry<String, Double> entry : this.studentNots.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public static ArrayList<Etudiants> getEtudiantsList() {
        return Etudiants.etudiants;
    }

}
