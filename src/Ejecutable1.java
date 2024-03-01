import Model.Entity.User;
import Model.Repos.RepoUser;

import java.security.NoSuchAlgorithmException;

public class Ejecutable1 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        RepoUser ru = RepoUser.getInstance();
        User u1=new User("Carlos","c","1234","c@g.com");
        User u2=new User("Ana","a","6789","a@a.com");
        ru.add(u1);
        ru.add(u2);
        ru.save();
    }
}
