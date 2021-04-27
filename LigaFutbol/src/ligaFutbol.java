import java.util.Random;

public class ligaFutbol {



    private Participantes equipos;

    private Juegos juegos;

    private int contJuegos;

    private float tempActual;

    //private int[] rolJuegos = {}



    private int equipo1;

    private int equipo2;

    private int equipo3;

    private int equipo4;



    public ligaFutbol() {

        equipos = new Participantes();

        equipos.addEquipo(new Equipo("Atletico de Madrid"));

        equipos.addEquipo(new Equipo("Chivas"));

        equipos.addEquipo(new Equipo("America"));

        equipos.addEquipo(new Equipo("Atletico San Pancho"));

        contJuegos = 1;

        juegos = new Juegos();

    }





    public void jornada() {

        Random aleatorio = new Random();

        while (true) {

            equipo1 = aleatorio.nextInt(4);

            equipo2 = aleatorio.nextInt(4);

            equipo3 = aleatorio.nextInt(4);

            equipo4 = aleatorio.nextInt(4);

            if (equipo1 != equipo2 && equipo1 != equipo3 && equipo1 != equipo4

                    && equipo2 != equipo3 && equipo2 != equipo4 && equipo3 != equipo4) {

                //	System.out.println("1.-" + equipo1 + " 2.- " + equipo2 + " 3.-"

                //		+ equipo3 + "4.-" + equipo4 );

                juego(equipo1, equipo2);

                contJuegos++;

                juego(equipo3, equipo4);

                contJuegos++;

                return;

            }

        }

    }



    public void juego(int equipo1, int equipo2) {

        Equipo local = equipos.getEquipo(equipo1);

        Equipo visitante = equipos.getEquipo(equipo2);

        //	System.out.println (local);

        //	System.out.println (visitante);

        Partido partido = new Partido(contJuegos,local.getNombre(),

                visitante.getNombre(), tempActual);

        juegos.addPartido(partido);

        String ganador = partido.getGanador();

        if (ganador.equals("Empate")) {

            local.incEmpates();

            visitante.incEmpates();

        } else {

            if (ganador.equals(local.getNombre())) {

                local.incVictorias();

                visitante.incDerrotas();

            } else {

                local.incDerrotas();

                visitante.incVictorias();

            }

        }

        local.setGolesMarcados(partido.getGolesEquipo1());

        visitante.setGolesMarcados(partido.getGolesEquipo2());

        local.setGolesPermitidos(partido.getGolesEquipo2());

        visitante.setGolesPermitidos(partido.getGolesEquipo1());



    }



    public void torneo() {

        Random creaTemperatura = new Random();

        int acumFrio = 0;

        while(true) {

            tempActual = creaTemperatura.nextInt(30);

            if (tempActual < 5) {

                acumFrio = acumFrio + 1;

            } else {

                acumFrio = 0;

                jornada();

            }

            if (acumFrio == 3) {

                imprimeResultados();

                return;

            }



        }

    }





    public void imprimeResultados() {



        for (int i = 0; i < 4; i++) {

            System.out.println(equipos.getEquipo(i));

        }



        for (Partido partido : juegos) {

            System.out.println(partido);

        }

    }

    /**

     * @param args

     */

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        ligaFutbol liga = new ligaFutbol();

        liga.torneo();



    }




}