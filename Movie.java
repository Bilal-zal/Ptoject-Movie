public class Movie {
   protected int iD;
    protected String title;
    protected String director;
    protected double rating;
    protected int year;
    public Movie left;
    public Movie right;
    public int height;
    
    
    public Movie(int iD, String title, String director, double rating, int year) {
        this.iD = iD;
        this.title = title;
        this.director = director;
        this.rating = rating;
        this.year = year;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

public int getID() {
        return iD;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }
    public void setID(int iD) {
        this.iD = iD;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setYear(int year) {
        this.year = year;
    }
}