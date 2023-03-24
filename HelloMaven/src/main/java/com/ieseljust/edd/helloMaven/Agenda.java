package com.ieseljust.edd.helloMaven;

import java.util.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    public static void main(String[] args) {

        ArrayList<Contactes> contactes = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear contacto");
            System.out.println("2. Esborrar contacto");
            System.out.println("3. Modificar contacto");
            System.out.println("4. Consultar contacto");
            System.out.println("5. Eixir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    crearContacte(contactes);
                    break;
                case 2:
                    esborrarContacte(contactes);
                    break;
                case 3:
                    modificarContacte(contactes);
                    break;
                case 4:
                    consultarContacte(contactes);
                    break;
                case 5:
                    System.out.println("Adéu!");
                    break;
                default:
                    System.out.println("Opció incorrecta");
            }
        } while (opcion != 5);
    }

    static Contactes getContacte(String nom, ArrayList<Contactes> contactes) {
        for (Contactes contacte : contactes) {
            if (contacte.getNom().equals(nom)) {
                return contacte;
            }
        }
        return null;
    }

    static int getPosicioContacte(String nom, ArrayList<Contactes> contactes) {
        for (int i = 0; i < contactes.size(); i++) {
            if (contactes.get(i).getNom().equals(nom)) {
                return i;
            }
        }
        return -1;
    }

    static void crearContacte(ArrayList<Contactes> contactes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nom del contacte: ");
        String nom = scanner.nextLine();
        System.out.print("Introdueix el telèfon del contacte: ");
        String telefon = scanner.nextLine();
        if (getContacte(nom, contactes) == null) {
            Contactes contacte = new Contactes(nom, telefon);
            contactes.add(contacte);
            System.out.println("Contacte afegit a la llista.");
        } else {
            System.out.println("El contacte ja existeix a la llista.");
        }
    }

    public static void esborrarContacte(ArrayList<Contactes> contactes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nom del contacte a esborrar: ");
        String nom = scanner.nextLine();

        // Busca el contacte a esborrar
        int posicio = getPosicioContacte(nom, contactes);

        if (posicio == -1) {
            System.out.println("El contacte no existeix en la llista.");
        } else {
            contactes.remove(posicio);
            System.out.println("El contacte ha sigut esborrat de la llista.");
        }
    }

    static void modificarContacte(ArrayList<Contactes> contactes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nom del contacte que vols modificar: ");
        String nom = scanner.nextLine();
        Contactes contacte = getContacte(nom, contactes);
        if (contacte != null) {
            System.out.println("Dades del contacte:");
            System.out.println(contacte.toString());
            System.out.print("Introdueix el nou nom del contacte: ");
            String nouNom = scanner.nextLine();
            System.out.print("Introdueix el nou telèfon del contacte: ");
            String nouTelefon = scanner.nextLine();
            contacte.setNom(nouNom);
            contacte.setTelefon(nouTelefon);
            System.out.println("Contacte modificat correctament.");
        } else {
            System.out.println("El contacte no existeix a la llista.");
        }
    }

    static void consultarContacte(ArrayList<Contactes> contactes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduiu el nom del contacte a consultar: ");
        String nom = sc.nextLine();
        int posicio = getPosicioContacte(nom, contactes);
        if (posicio == -1) {
            System.out.println("El contacte no existeix.");
        } else {
            Contactes contacte = contactes.get(posicio);
            System.out.println("Telèfon de " + nom + ": " + contacte.getTelefon());
        }
    }

}
