package Pequenos_Creadores;

import java.util.ArrayList;
//import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Programa> programas = new ArrayList<>();
        Programa dibujo = new Programa("Dibujo", 2500000, 6, 7);
        Programa pintura = new Programa("Pintura", 2700000, 8, 9);
        Programa escultura = new Programa("Escultura", 2700000, 10, 12);
        programas.add(dibujo);
        programas.add(pintura);
        programas.add(escultura);
        double valorAdicionales = 0;
        int respuestaNuevoEstudiante = JOptionPane.YES_OPTION;

        while (respuestaNuevoEstudiante == JOptionPane.YES_OPTION){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del niño: ");
        String edadTxt = JOptionPane.showInputDialog("Ingrese la edad de " + nombre + ": ");
        int edad = Integer.parseInt(edadTxt);

        Programa programaAplicado = null;
        for (Programa programa : programas) {
            if (edad >= programa.getEdadMinima() && edad <= programa.getEdadMaxima()) {
                programaAplicado = programa;
                break;
            }
        }
        if (programaAplicado == null) {
            JOptionPane.showMessageDialog(null, "No hay programas disponibles para la edad de " + edad);
        } else {
            JOptionPane.showMessageDialog(null, "Aplica para el programa " + programaAplicado.getNombre()
                    + " con un costo de " + programaAplicado.getValorBase());
            int respuestaAceptaPrograma = JOptionPane.showConfirmDialog(null,
                    "Desea matricular a " + nombre + " en el programa de " + programaAplicado.getNombre() + "?",
                    "Acepta programa", JOptionPane.YES_NO_OPTION);

            if (respuestaAceptaPrograma == JOptionPane.YES_OPTION) {
                int respuestaAceptaEspeciales = JOptionPane.showConfirmDialog(null,
                        "Quiere adicionar Materiales premium con un costo adicional de "
                                + Programa.VALOR_MAERIALES_ESPECIALES + "?",
                        "Materiales premium", JOptionPane.YES_NO_OPTION);
                if (respuestaAceptaEspeciales == JOptionPane.YES_OPTION) {
                    valorAdicionales += Programa.VALOR_MAERIALES_ESPECIALES;
                }
                int respuestaAceptaTalleres = JOptionPane.showConfirmDialog(null,
                        "Quiere adicionar Talleres de fin de semana con un costo adicional de "
                                + Programa.VALOR_TALLERES_FIN_DE_SEMANA + "?",
                        "Talleres de fin de semana", JOptionPane.YES_NO_OPTION);
                if (respuestaAceptaTalleres == JOptionPane.YES_OPTION) {
                    valorAdicionales += Programa.VALOR_TALLERES_FIN_DE_SEMANA;
                }
                int respuetaAceptaIntensivas = JOptionPane.showConfirmDialog(null,
                        "Quiere adicionar Clases intensivas con un costo adicional de "
                                + Programa.VALOR_CLASES_INTENSIVAS + "?",
                        "Clases intensivas", JOptionPane.YES_NO_OPTION);
                if (respuetaAceptaIntensivas == JOptionPane.YES_OPTION) {
                    valorAdicionales += Programa.VALOR_CLASES_INTENSIVAS;
                }
                double valorTotal = programaAplicado.getValorBase() + valorAdicionales;
                JOptionPane.showMessageDialog(null, "El valor total a pagar por " + nombre + " es de " + valorTotal);
            }

        }
        respuestaNuevoEstudiante = JOptionPane.showConfirmDialog(null, "Desea ingresar un nuevo estudiante?",
                "Nuevo estudiante", JOptionPane.YES_NO_OPTION);
    }
    }
}
