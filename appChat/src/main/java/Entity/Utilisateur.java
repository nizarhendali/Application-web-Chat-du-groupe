package Entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur {

        @Id @Column(length = 100)
        private String IdUtil;
        String nom;
        String password;

        int permission;
        String type;
        @OneToMany(mappedBy = "util")
        List<Message> messages;


        public  Utilisateur(String id,String n, String pa,String type){
            this.IdUtil=id;
            this.nom=n;
            this.password=pa;
            this.permission=3;
            this.type=type;
        }

    public Utilisateur() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdUtil() {
        return IdUtil;
    }

    public void setIdUtil(String idUtil) {
        IdUtil = idUtil;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "IdUtil=" + IdUtil +
                ", nom='" + nom + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
