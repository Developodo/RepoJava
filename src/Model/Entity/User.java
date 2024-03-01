package Model.Entity;

import Model.Utils.Security;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class User implements Serializable {
    private String name;
    private String username; //key
    private String password;
    private String mail; //unique

    public User() {}
    public User(String username) throws NoSuchAlgorithmException {
        this("",username,"","");
    }
    public User(String name, String username, String password, String mail) throws NoSuchAlgorithmException {
        this.name = name;
        this.username = username;
        setPassword(password);
        this.mail = mail;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = Security.hashPassword(password);
    }
    public boolean isMyPassword(String password) throws NoSuchAlgorithmException {
        return this.password.equals(Security.hashPassword(password));
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) || Objects.equals(mail, user.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, mail);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
