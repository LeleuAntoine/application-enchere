package fr.eni.javaee.applicationenchere.services.users;

import fr.eni.javaee.applicationenchere.model.SecurityUsers;
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
    public SecurityUsers saveUser(SecurityUsers user) {
        return usersDAO.save(user);
    }

    @Override
    public SecurityUsers updateUser(SecurityUsers user) {
        return usersDAO.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersDAO.deleteById(userId);
    }

    @Override
    public SecurityUsers findByEmail(String email){
        return usersDAO.findByEmail(email);
    }

}
