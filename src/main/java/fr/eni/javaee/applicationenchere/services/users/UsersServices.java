package fr.eni.javaee.applicationenchere.services.users;

import fr.eni.javaee.applicationenchere.model.Users;

public interface UsersServices {

    Users saveUser(Users user);

    Users updateUser(Users user);

    void deleteUser(Integer userId);
}
