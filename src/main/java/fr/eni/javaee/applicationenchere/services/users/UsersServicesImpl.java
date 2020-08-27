package fr.eni.javaee.applicationenchere.services.users;

import fr.eni.javaee.applicationenchere.model.Users;
import fr.eni.javaee.applicationenchere.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("usersService")
@Transactional
public class UsersServicesImpl implements UsersServices {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public Users saveUser(Users user) {
        return (Users) usersDAO.save(user);
    }

    @Override
    public Users updateUser(Users user) {
        return (Users) usersDAO.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersDAO.deleteById(userId);
    }

    @Override
    public Users findUsersByEmail(String email){
        return usersDAO.findUsersByEmailIgnoreCase(email);
    }

}
