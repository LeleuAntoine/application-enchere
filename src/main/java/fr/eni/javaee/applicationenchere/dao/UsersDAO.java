package fr.eni.javaee.applicationenchere.dao;

import fr.eni.javaee.applicationenchere.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository {

    Users findUsersByEmailIgnoreCase(String email);

}
