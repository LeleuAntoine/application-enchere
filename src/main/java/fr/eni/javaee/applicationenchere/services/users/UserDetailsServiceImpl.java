package fr.eni.javaee.applicationenchere.services.users;

import fr.eni.javaee.applicationenchere.dao.UsersDAO;
import fr.eni.javaee.applicationenchere.model.SecurityUsers;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UsersDAO usersDAO;

    public UserDetailsServiceImpl(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        SecurityUsers securityUsers = usersDAO.findByPseudo(pseudo);
        if (securityUsers == null) {
            throw new UsernameNotFoundException(pseudo);
        }
        return new User(securityUsers.getPseudo(), securityUsers.getMotDePasse(), emptyList());
    }
}
//Confirmation
