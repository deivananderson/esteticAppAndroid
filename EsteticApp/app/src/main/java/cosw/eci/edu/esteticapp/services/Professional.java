package cosw.eci.edu.esteticapp.services;

/**
 * Created by USUARIO on 25/04/2017.
 */

public class Professional {

    private String name;
    private String id;
    private String email;
    private String password;
    private String imageUrl;
    private String services;

    public Professional(String name, String email,String services) {
        this.name = name;
        this.services = services;
        this.email = email;
    }

    public Professional(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getImageUrl() { return imageUrl; }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
