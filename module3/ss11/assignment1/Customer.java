package entities;

import java.time.LocalDate;

public class Customer {
    private String name;
    private LocalDate born;
    private String place;
    private String url;

    public Customer(String name, LocalDate born, String place, String url) {
        this.name = name;
        this.born = born;
        this.place = place;
        this.url = url;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
