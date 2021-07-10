public class Publicacion {

    private final String code;
    private final String title;
    private final int year;

    public Publicacion(String code, String title, int year) {
        this.code = code;
        this.title = title;
        this.year = year;

    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

}