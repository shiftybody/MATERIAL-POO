public class Weather {

    private String city;
    private double min;
    private double max;

    public Weather(String newCity){
         city = newCity;
    }

     public void setMin(Double newMin){
         min = newMin;
     }

    public void setMax(Double newMax){
        min = newMax;
    }

    public String getCity(){
         return city;
    }

    public double getMin(){
         return min;
    }

    public double getMax(){
         return max;
    }

    public String getResultado (){

        return  "<city> \n " +
                "      <name> " + city + "</name> \n " +
                "      <lowest_temperature> " + min + " </lowest_temperture> \n " +
                "      <highest_temperature> " + max + " </highest_temperture> \n " +
                "</city>";
    }
}
