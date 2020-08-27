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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * Transforme une entity Users en un POJO UserDTO
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
     * Transforme un POJO UserDTO en une entity Users
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
