public class PruebaSeries {
    public static void main(String[] args) {
        CreaSerie serieDos = new CreaSerie();
        for (int i = 0; i < 5; i++) {
            System.out.println("Siguiente valor es " + serieDos.getSiguiente());
        }

        System.out.println("Reinciar");
        serieDos.reiniciar();
        for (int i = 0; i < 5; i++) {
            System.out.println("Siguiente valor es " + serieDos.getSiguiente());
        }
        System.out.println("Inicir en 148");
        serieDos.setComenzar(148);

        for (int i = 0; i < 5; i++) {
            System.out.println("Siguiente valor es " + serieDos.getSiguiente());
        }

    }
}
