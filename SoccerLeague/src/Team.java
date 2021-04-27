public class Team {

    int division;
    String name;
    String code;
    int points;
    int played;
    int scored;
    int conceded;
    int difference;

    public Team(int division,String code, String name){
        this.division = division;
        this.code = code;
        this.name = name;
    }

    public void addResult(int home, int away){

    }

    public void print() {
        System.out.println(division + "\t" + code + "\t" + points);
    }

}
