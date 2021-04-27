import java.time.temporal.TemporalAmount;
import java.util.Vector;

public class League {
    Vector<Team> teams;

    String [] lits1 = {"AR arad", "BR braila", "CR craiova"," DR Drobeta"};

    public League(){
        teams = new Vector<Team>();
    }

    public void setupDiv1(){
        for (int i = 0; i < lits1.length; i++) {
            String code = lits1[i].substring(0,2);
            String name = lits1[i].substring(3);
            addTeam(i, code, name);
        }
    }
    public void addTeam(int division, String code, String name){
        Team aTeam = new Team(division, code, name);
        teams.add(aTeam);
    }

    public void print(){
        for (Team aTeam: teams
             ) {
            aTeam.print();
        }
    }
}
