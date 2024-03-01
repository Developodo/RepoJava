package Model.Repos;

import Model.Entity.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoUser extends Repository<User,String>{
    private final static String FILENAME ="users.bin";
    private static RepoUser _instance;
    private Set<User> users;

    private RepoUser(){
        users = new HashSet<>();
    }
    public static RepoUser getInstance(){
        if(_instance==null){
            _instance = (RepoUser) load(FILENAME);
            if(_instance==null){
                _instance=new RepoUser();
            }
        }
        return _instance;
    }


    @Override
    public User add(User data) {
        User result=null;
        if(users.add(data)){
            result=data;
        }
        return result;
    }

    @Override
    public User getById(String id) {
        User result=null;
        for(User user:users){
            if(user.getUsername().equals(id)){
                result=user;
                break;
            }
        }
        return result;
    }

    @Override
    public Collection<User> getAll() {
        return users;
    }

    @Override
    public User update(User data) {
        User result=null;
        result=getById(data.getUsername());
        if(result!=null){
            users.remove(result);
            users.add(data);
            result=data;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        return users.remove(getById(id));
    }

    public boolean save(){
        return save(FILENAME);
    }
}
