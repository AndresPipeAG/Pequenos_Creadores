package Pequenos_Creadores;

import java.util.ArrayList;

public class Programa {

    public static final double VALOR_MAERIALES_ESPECIALES = 300000;
    public static final double VALOR_TALLERES_FIN_DE_SEMANA = 150000;
    public static final double VALOR_CLASES_INTENSIVAS = 200000;
    
    String nombre;
    double valorBase;
    int edadMinima;
    int edadMaxima;
    ArrayList<Nino> estudiantes;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getValorBase() {
        return valorBase;
    }
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
    public int getEdadMinima() {
        return edadMinima;
    }
    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
    public int getEdadMaxima() {
        return edadMaxima;
    }
    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    //Constructor

    public Programa(String nombre, double valorBase, int edadMinima, int edadMaxima) {
        this.nombre = nombre;
        this.valorBase = valorBase;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.estudiantes = new ArrayList<>();
    }

    //Metodos
    public ArrayList<Nino> obtenerEstudiantes() {
        return this.estudiantes;
    }




}
