package br.edu.infnet.SpringMVC.Model.Domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mail;
    private String password;

   @OneToMany
   @JoinColumn(name = "id_user")
   private List<Friend> friends;

   public List<Friend> getFriends(){return friends;}

    public void setFriends(List<Friend> friends){this.friends = friends;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return id + "" + name + "" + mail + "" + password;
    }
}
