package service;

import com.example.fines_saveurs.dao.UserDao;
import com.example.fines_saveurs.dao.UserJdbcDao;
import com.example.fines_saveurs.model.User;

public class UserService {
    private UserDao userDao = new UserJdbcDao();
    public boolean login(String email, String password) {
        User userFound = userDao.findByEmail(email);
        if (userFound != null) {
            return userFound.getPassword().equals(password);
        }
        return false;
    }
}
