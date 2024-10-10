package Pequenos_Creadores;

import java.util.ArrayList;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        DecimalFormat formater = new DecimalFormat("###,###.##");
        ArrayList<Programa> programas = new ArrayList<>();
        Programa dibujo = new Programa("Dibujo", 2500000, 6, 7);
        Programa pintura = new Programa("Pintura", 2700000, 8, 9);
        Programa escultura = new Programa("Escultura", 2700000, 10, 12);
        programas.add(dibujo);
        programas.add(pintura);
        programas.add(escultura);
        double valorAdicionales = 0;
        int respuestaNuevoEstudiante = JOptionPane.YES_OPTION;

        while (respuestaNuevoEstudiante == JOptionPane.YES_OPTION) {
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
                        + " con un costo de $" + formater.format(programaAplicado.getValorBase()));
                int respuestaAceptaPrograma = JOptionPane.showConfirmDialog(null,
                        "Desea matricular a " + nombre + " en el programa de " + programaAplicado.getNombre() + "?",
                        "Acepta programa", JOptionPane.YES_NO_OPTION);

                if (respuestaAceptaPrograma == JOptionPane.YES_OPTION) {
                    double valorTotal = programaAplicado.getValorBase();

                    Nino nino = new Nino(nombre, edad, false, false, false);
                    programaAplicado.obtenerEstudiantes().add(nino);

                    int respuestaAceptaEspeciales = JOptionPane.showConfirmDialog(null,
                            "Quiere adicionar Materiales premium con un costo adicional de $"
                                    + formater.format(Programa.VALOR_MAERIALES_ESPECIALES) + "?",
                            "Materiales premium", JOptionPane.YES_NO_OPTION);
                    if (respuestaAceptaEspeciales == JOptionPane.YES_OPTION) {
                        nino.setTieneMateriales(true);
                        valorTotal += Programa.VALOR_MAERIALES_ESPECIALES;
                        //valorAdicionales += Programa.VALOR_MAERIALES_ESPECIALES;
                    }

                    int respuestaAceptaTalleres = JOptionPane.showConfirmDialog(null,
                            "Quiere adicionar Talleres de fin de semana con un costo adicional de $"
                                    + formater.format(Programa.VALOR_TALLERES_FIN_DE_SEMANA) + "?",
                            "Talleres de fin de semana", JOptionPane.YES_NO_OPTION);
                    if (respuestaAceptaTalleres == JOptionPane.YES_OPTION) {
                        nino.setTieneTalleres(true);
                        valorTotal += Programa.VALOR_TALLERES_FIN_DE_SEMANA;
                        //valorAdicionales += Programa.VALOR_TALLERES_FIN_DE_SEMANA;
                    }

                    int respuetaAceptaIntensivas = JOptionPane.showConfirmDialog(null,
                            "Quiere adicionar Clases intensivas con un costo adicional de $"
                                    + formater.format(Programa.VALOR_CLASES_INTENSIVAS) + "?",
                            "Clases intensivas", JOptionPane.YES_NO_OPTION);
                    if (respuetaAceptaIntensivas == JOptionPane.YES_OPTION) {
                        nino.setTieneClases(true);
                        valorTotal += Programa.VALOR_CLASES_INTENSIVAS;
                        //valorAdicionales += Programa.VALOR_CLASES_INTENSIVAS;
                    }

                    JOptionPane.showMessageDialog(null,
                            "El valor total a pagar por " + nombre + " es de $" + formater.format(valorTotal));
                }

            }
            respuestaNuevoEstudiante = JOptionPane.showConfirmDialog(null, "Desea ingresar un nuevo estudiante?",
                    "Nuevo estudiante", JOptionPane.YES_NO_OPTION);
        }//Fin While

        String informacion = "";
        
        
        double valorTotalEscuela= 0;
        for (Programa programa : programas) {
            informacion += "Nombre Programa: " + programa.getNombre() + "\n";
            ArrayList<Nino> estudiantesPrograma = programa.obtenerEstudiantes();
            double valorTotalPrograma = 0;
            if (programa.obtenerEstudiantes().size() > 0){         
                
                for (Nino nino : estudiantesPrograma){                    
                    informacion += String.format("\n* %s (%d años) : \n  -Base: $%s", nino.getNombre(), nino.getEdad(), formater.format(programa.getValorBase()));
                    double valorTotalNino = 0;
                    valorTotalNino += programa.getValorBase();
                    if( nino.isTieneMateriales()){
                        informacion += String.format("\n   -Materiales: $%s", formater.format(Programa.VALOR_MAERIALES_ESPECIALES));
                        valorTotalNino += Programa.VALOR_MAERIALES_ESPECIALES;
                    }else{
                        informacion += "\n   -Materiales: $0";
                    }
                    if(nino.isTieneTalleres()){
                        informacion += String.format("\n-   Talleres: $%s", formater.format(Programa.VALOR_TALLERES_FIN_DE_SEMANA));
                        valorTotalNino += Programa.VALOR_TALLERES_FIN_DE_SEMANA;
                    }else {
                        informacion += "\n   -Talleres: $0";
                    }
                    if (nino.isTieneClases()){
                        informacion += String.format("\n   -Clases: $%s", formater.format(Programa.VALOR_CLASES_INTENSIVAS));
                        valorTotalNino += Programa.VALOR_CLASES_INTENSIVAS;                       
                    }else {
                        informacion += "\n   -Clases: $0";
                    }
                    informacion += String.format("\n   -TOTAL A PAGAR: $%s", formater.format(valorTotalNino));
                    valorTotalPrograma += valorTotalNino;
                }
                valorTotalEscuela += valorTotalPrograma;
                informacion += String.format("\n TOTAL PROGRAMA: $%s \n", formater.format(valorTotalPrograma));
            }else {
                informacion += "No hay estudiantes matriculados en este programa\n";
            }
            informacion += "___________________________________________________________________\n";
        }
        informacion += String.format("VALOR TOTAL ESCUELA: $%s", formater.format(valorTotalEscuela));
        JOptionPane.showMessageDialog(null, informacion + "\n");

    }
}
