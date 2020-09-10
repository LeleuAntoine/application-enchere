//package fr.eni.javaee.applicationenchere;
//
//import fr.eni.javaee.applicationenchere.model.SecurityUsers;
//import fr.eni.javaee.applicationenchere.model.Role;
//import fr.eni.javaee.applicationenchere.services.users.UsersServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDetailService {
//    @Autowired
//    private UsersServices userService;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
//
//        if (pseudo.trim().isEmpty()) {
//            throw new UsernameNotFoundException("username is empty");
//        }
//
//        SecurityUsers user = userService.findByPseudo(pseudo);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User " + pseudo + " not found");
//        }
//
//        return new org.springframework.security.core.userdetails.User(user.getPseudo(), user.getMotDePasse(), getGrantedAuthorities(user));
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(SecurityUsers user) {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//        SecurityUsers securityUsers = user.getAdministrateur();
//        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//        return authorities;
//    }
//}
