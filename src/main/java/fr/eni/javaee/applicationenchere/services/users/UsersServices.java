package fr.eni.javaee.applicationenchere.services.users;

import fr.eni.javaee.applicationenchere.model.SecurityUsers;

public interface UsersServices{

    SecurityUsers saveUser(SecurityUsers user);

    SecurityUsers updateUser(SecurityUsers user);

    void deleteUser(Integer userId);

    SecurityUsers findByEmail(String email);

    SecurityUsers findByPseudo(String pseudo);

    boolean checkIfIdexists(Integer id);

    SecurityUsers findByMotDePasse(String motDePasse);

}
