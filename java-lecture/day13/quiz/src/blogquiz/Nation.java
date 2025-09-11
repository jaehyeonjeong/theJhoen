package blogquiz;

public class Nation {
    private String country;
    private String capital;

    @Override
    public String toString() {
        return "Nation{" +
                "country='" + country + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Nation(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }
}
