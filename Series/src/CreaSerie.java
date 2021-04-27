public class CreaSerie implements Series{

    int iniciar;
    int valor;
    int anterior;

    public CreaSerie(){
        iniciar = 0;
        valor =0;
    }

    @Override
    public int getSiguiente() {
        anterior = valor;
        valor += 2;
        return valor;
    }

    @Override
    public void reiniciar() {
        valor = iniciar;
    }

    @Override
    public void setComenzar(int valor) {
        anterior = valor -2;
        iniciar = valor;
        this.valor = valor;
    }

    public int getAnterior(){
        return anterior;
    }
}
