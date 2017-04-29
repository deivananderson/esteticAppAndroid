package cosw.eci.edu.esteticapp.services;

/**
 * Created by USUARIO on 26/04/2017.
 */

public class Reservation {

    private String professional;
    private String services;
    private String date;
    private String price;
    private String state;
    private String imageUrl;

    public Reservation(String professional, String services, String date, String price, String state) {
        this.professional = professional;
        this.services = services;
        this.date = date;
        this.price = price;
        this.state = state;
    }

    public Reservation(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImageUrl() {return imageUrl;}

    @Override
    public int hashCode() {return super.hashCode();}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
