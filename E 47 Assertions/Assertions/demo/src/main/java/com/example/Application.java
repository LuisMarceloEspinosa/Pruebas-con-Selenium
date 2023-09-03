package com.example;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> pasosLavadoDientes = new ArrayList<>();

        // Agregar pasos a la lista
        pasosLavadoDientes.add("Agarrar el cepillo de dientes");
        pasosLavadoDientes.add("Mojar el cepillo de dientes");
        pasosLavadoDientes.add("Destapar la pasta dental");
        pasosLavadoDientes.add("Aplicar pasta dental en el cepillo");
        pasosLavadoDientes.add("Cepillar los dientes durante 2 minutos");
        pasosLavadoDientes.add("Enjuagar la boca con agua");
        pasosLavadoDientes.add("Limpiar el cepillo y guardarlo");

        // Imprimir la lista de pasos
        System.out.println("Pasos para lavarse los dientes:");
        for (String paso : pasosLavadoDientes) {
            System.out.println("- " + paso);
        }
    }
}
