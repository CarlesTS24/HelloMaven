package com.ieseljust.edd.helloMaven;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pantalla {
    // ======== FUNCIONS PER A L'EIXIDA DE DADES PER PANTALLA ==========

    /**
     * Mostra el text passat com a paràmetre en un format especial. Li posa un
     * Quadradet al voltant, segons la grandària del text.
     *
     * @param text Text del títol
     * @param espais Espais a l'esquerra del títol
     */
    public static void titol(String text, String espais) {
        if (text == null) {
            text = "";
        }
        System.out.println("");
        System.out.print(espais);
        for (int i = 0; i < text.length() + 4; i++) {
            System.out.print("*");
        }
        System.out.println("\n" + espais + "* " + text + " *");
        System.out.print(espais);
        for (int i = 0; i < text.length() + 4; i++) {
            System.out.print("*");
        }
        System.out.println("\n");
    }

    /**
     * Mostra el text passat com a paràmetre en un format especial. Li posa un
     * Quadradet al voltant, segons la grandària del text.
     *
     * @param text Text del títol
     */
    public static void titol(String text) {
        titol(text, "");
    }

    /**
     * Mostra el text passat com a paràmetre en un format especial
     * i un poc centrat en la pantalla. 
     * Li posa un Quadradet al voltant, segons la grandària del text.
     *
     * @param text Text del títol
     */
    public static void titolCentrat2(String text) {
        titol(text, "\t");
    }

    /**
     * Escriu un títol amb una línia baix d'igual grandària.
     * @param text El text del títol a mostrar
     */
    public static void titolet(String text) {
        System.out.println(text);
        linia(text.length());
    }


    /**
     * Dibuixa una línia de ratlletes de la grandària especificada.
     * @param n Grandària de la línia (en quantitat de caràcters)
     */
    public static void linia(int n) {
        System.out.println(getLinia(n));
    }

    /**
     * Retorna una línia de ratlletes de la grandària especificada.
     * És invocada (entre altres) pel toString de la classe Serie.
     * @param n Grandària de la línia (en quantitat de caràcters)
     * @return la línia de ratlletes.
     */
    public static String getLinia(int n) {
        String linia = "";
        for (int i = 0; i < n; i++) {
            linia = linia + '-';
        }
        return linia;
    }

    /**
     * Retorna un text que càpiga en un tros, alineat a esquerra. 
     * Pensat per a ser usat en el toString.
     * @param text Text del qual volem obtindre un tros
     * @param espais Quantitat d'espais que ha d'ocupar el text
     * @return El text amb eixos espais (sempre retorna un blanc al final)
     */
    public static String tros(String text, int espais) {
        int l = text.length();

        if (l >= espais) {
            text = text.substring(0, espais - 1) + ' '; // un espai al final
        } else {
            int falten = espais - l;
            for (int i = 0; i < falten; i++) {
                text = text + " ";
            }
        }
        return text;
    }

    /**
     * Retorna un número que càpiga en un tros, alineat a dreta. 
     * Pensat per a ser usat en el toString
     *
     * @param numero Número del qual volem posar en un tros
     * @param espais Quantitat d'espais que ha d'ocupar el número
     * @return El text amb eixos espais (sempre retorna un blanc al final)
     */
    public static String tros(int numero, int espais) {
        String text = numero + "";

        while (text.length() < espais - 1) {
            text = ' ' + text;
        }
        return text + ' '; // Un espai al final
    }


    /**
     * Retorna el toString d'un ArrayList de Strings però en altre format.
     * S'utilitza per a mostrar llistes d'autors, actors i artistes. És a dir:
     * es invocat pel toString de les classes que contenen eixes llistes.
     *
     * @param strings llista de cadenes
     * @return cadena de cadenes separades per coma
     */
    public static String llistaStrings(ArrayList<String> strings) {
        String cadena = "";
        if (strings == null || strings.size() == 0){
            return "";
        }
        for (int i = 0; i < strings.size() - 1; i++) {
            cadena = cadena + strings.get(i) + ", ";
        }
        if (!strings.isEmpty()) {
            cadena = cadena + strings.get(strings.size() - 1);
        }
        return cadena;
    }

}