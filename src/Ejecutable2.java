import Model.Entity.User;
import Model.Repos.RepoUser;

public class Ejecutable2 {
    public static void main(String[] args) {
        RepoUser ru=RepoUser.getInstance();
        for(User u:ru.getAll()){
            System.out.println(u);
        }
    }
}
