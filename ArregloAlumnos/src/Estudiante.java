import java.util.Scanner;

public class Estudiante {

    private int expediente;
    private String nombre;
    private String carrera;
    private double promedio;

    public Estudiante (int exp, String nombre, String carrera, double promedio){
        this.expediente = exp;
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCarrera(){
        return carrera;
    }

    public int getExpediente(){
        return expediente;
    }

    public double getPromedio(){
        return promedio;
    }

    @Override
    public String toString(){
        return "Expediente " + expediente + " nombre: "+nombre + " carrera " + carrera + " promedio" +  promedio;
    }

}
