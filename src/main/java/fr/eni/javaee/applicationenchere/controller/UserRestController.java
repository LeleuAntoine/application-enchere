package fr.eni.javaee.applicationenchere.controller;

import fr.eni.javaee.applicationenchere.dao.UsersDAO;
import fr.eni.javaee.applicationenchere.dto.UserDTO;
import fr.eni.javaee.applicationenchere.model.SecurityUsers;
import fr.eni.javaee.applicationenchere.services.users.UsersServicesImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRestController {

    @Autowired
    private UsersServicesImpl usersServices;
    private UsersDAO usersDAO;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRestController(UsersDAO usersDAO,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersDAO = usersDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * Ajoute un nouvel utilisateur
     *
     * @param userDTORequest
     * @return
     */
    @PostMapping(value = "/sign-up")
    public ResponseEntity<UserDTO> createNewUser(@RequestBody UserDTO userDTORequest) {
        SecurityUsers existsUserMail = usersServices.findByEmail(userDTORequest.getEmail());
        SecurityUsers existsUserPseudo = usersServices.findByPseudo(userDTORequest.getPseudo());
        userDTORequest.setMotDePasse(bCryptPasswordEncoder.encode(userDTORequest.getMotDePasse()));
        if (existsUserMail != null && existsUserPseudo != null) {
            return new ResponseEntity<UserDTO>(HttpStatus.CONFLICT);
        }
        SecurityUsers userRequest = mapUserDTOToUser(userDTORequest);
        SecurityUsers userResponse = usersServices.saveUser(userRequest);
        if (userResponse != null) {
            UserDTO userDTO = mapUserToUserDTO(userResponse);

            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
        }
        return new ResponseEntity<UserDTO>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Met à jour les données d'un utilisateur dans la base de données.
     *
     * @param userDTORequest
     * @return
     */
    @PutMapping("/updateUser")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTORequest) {
        if (!usersServices.checkIfIdexists(userDTORequest.getUserId())) {
            return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
        }
        SecurityUsers userRequest = mapUserDTOToUser(userDTORequest);
        SecurityUsers userResponse = usersServices.updateUser(userRequest);
        if (userResponse != null) {
            UserDTO userDTO = mapUserToUserDTO(userResponse);
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
        }
        return new ResponseEntity<UserDTO>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Supprime un client dans la base de données.
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        usersServices.deleteUser(userId);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    /**
     * Transforme une entitée Users en un UserDTO
     *
     * @param user
     * @return
     */
    private UserDTO mapUserToUserDTO(SecurityUsers user) {
        ModelMapper mapper = new ModelMapper();
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        return userDTO;
    }

    /**
     * Transforme un UserDTO en une entité Users
     *
     * @param userDTO
     * @return
     */
    private SecurityUsers mapUserDTOToUser(UserDTO userDTO) {
        ModelMapper mapper = new ModelMapper();
        SecurityUsers user = mapper.map(userDTO, SecurityUsers.class);
        return user;
    }
}

