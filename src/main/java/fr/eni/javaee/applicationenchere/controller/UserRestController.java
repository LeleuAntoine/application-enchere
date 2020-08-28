package fr.eni.javaee.applicationenchere.controller;

import fr.eni.javaee.applicationenchere.dto.UserDTO;
import fr.eni.javaee.applicationenchere.model.SecurityUsers;
import fr.eni.javaee.applicationenchere.services.users.UsersServicesImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/api")
public class UserRestController {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UsersServicesImpl usersServices;

//    @Autowired
//    private JavaMailSender javaMailSender;

    /**
     * Ajoute un nouvel utilisateur
     *
     * @param UserDTORequest
     * @return
     */
    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> createNewUser(@RequestBody UserDTO UserDTORequest) {
        SecurityUsers existsUser = usersServices.findByEmail(UserDTORequest.getEmail());
        if (existsUser != null) {
            return new ResponseEntity<UserDTO>(HttpStatus.CONFLICT);
        }
        SecurityUsers userRequest = mapUserDTOToUser(UserDTORequest);
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
        SecurityUsers customerResponse = usersServices.updateUser(userRequest);
        if (customerResponse != null) {
            UserDTO customerDTO = mapUserToUserDTO(customerResponse);
            return new ResponseEntity<UserDTO>(customerDTO, HttpStatus.OK);
        }
        return new ResponseEntity<UserDTO>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Supprime un client dans la base de données.
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/deleteCustomer/{customerId}")
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

//    /**
//     * Retourne l'utilisateur ayant l'adresse email passée en paramètre.
//     * @param email
//     * @return
//     */
//    @GetMapping("/searchByEmail")
//    public ResponseEntity<CustomerDTO> searchCustomerByEmail(@RequestParam("email") String email) {
//        //, UriComponentsBuilder uriComponentBuilder
//        Customer customer = customerService.findCustomerByEmail(email);
//        if (customer != null) {
//            CustomerDTO customerDTO = mapCustomerToCustomerDTO(customer);
//            return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
//        }
//        return new ResponseEntity<CustomerDTO>(HttpStatus.NO_CONTENT);
//    }

}
