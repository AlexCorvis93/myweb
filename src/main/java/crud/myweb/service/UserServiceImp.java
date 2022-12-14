package crud.myweb.service;


import crud.myweb.dao.UserDao;
import crud.myweb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private UserDao userDao;


    public UserServiceImp (UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> users() {
        return userDao.users();
    }


    @Transactional(readOnly = true)
    @Override
    public User showUser(int id) {
        return userDao.showUser(id);
    }


    @Transactional
    @Override
    public void remove(int id) {
        userDao.remove(id);
    }


    @Transactional
    @Override
    public void update(int id, User user) {
        userDao.update(id, user);

    }

}
