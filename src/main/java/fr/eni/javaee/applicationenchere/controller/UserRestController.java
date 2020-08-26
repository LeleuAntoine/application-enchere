package fr.eni.javaee.applicationenchere.controller;

import fr.eni.javaee.applicationenchere.bo.Users;
import fr.eni.javaee.applicationenchere.controller.DTO.UserDTO;
import fr.eni.javaee.applicationenchere.services.users.UsersServicesImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/users/api")
public class UserRestController {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UsersServicesImpl usersServices;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Ajoute un nouvel utilisateur
     *
     * @param UserDTORequest
     * @return
     */
    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> createNewUser(@RequestBody UserDTO UserDTORequest) {
        Users existsUser = usersServices.findUserByEmail(UserDTORequest.getEmail());
        if (existsUser != null) {
            return new ResponseEntity<UserDTO>(HttpStatus.CONFLICT);
        }
        Users userRequest = mapUserDTOToUser(UserDTORequest);
        userRequest.setCreationDate(LocalDate.now());
        Users customerResponse = usersServices.saveUser(userRequest);
        if (customerResponse != null) {
            UserDTO userDTO = mapUserToUserDTO(customerResponse);
            return new ResponseEntity<UserDTO>(UserDTO, HttpStatus.CREATED);
        }
        return new ResponseEntity<UserDTO>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Transforme une entity Users en un POJO UserDTO
     *
     * @param user
     * @return
     */
    private UserDTO mapUserToUserDTO(Users user) {
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
    private Users mapUserDTOToUser(UserDTO userDTO) {
        ModelMapper mapper = new ModelMapper();
        Users user = mapper.map(userDTO, Users.class);
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
