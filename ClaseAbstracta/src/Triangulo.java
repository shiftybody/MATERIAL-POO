public class Triangulo extends Figura{

    private double base;
    private double altura;
    public Triangulo(String color, double base, double altura){
        super(color);
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calucloArea() {
        return (base * altura)/2;
    }

}
