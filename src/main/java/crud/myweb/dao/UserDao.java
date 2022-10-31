package crud.myweb.dao;



import crud.myweb.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> users();

    User showUser(int id);

    void remove(int id);

    void update(int id, User user);

}
