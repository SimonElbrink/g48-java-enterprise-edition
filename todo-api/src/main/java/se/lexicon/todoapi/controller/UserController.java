package se.lexicon.todoapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.lexicon.todoapi.domain.dto.UserDTOForm;
import se.lexicon.todoapi.domain.dto.UserDTOView;
import se.lexicon.todoapi.service.UserService;

// TODO: In Postman application, create POST-requests based on this API, to seed the application with some users.

@RequestMapping("/api/v1/users") // http://localhost:8080/api/v1/users
@RestController // RestController annotation is used to create a RESTful web service
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<UserDTOView> doGetUserEmail(@RequestParam String email){
        System.out.println(" >>>>>>>> doGetUserEmail Method Executed");
        System.out.println("Email requested: " + email);

        UserDTOView dto = userService.getByEmail(email);

        return ResponseEntity.ok(dto);
    }

    /**
     * This method is used to create User for this application
     * @param userDTOForm
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<UserDTOView> doRegister(@RequestBody @Valid UserDTOForm userDTOForm){

        System.out.println(" >>>>>>>> doRegister Method Executed");
        System.out.println("userDTOForm = " + userDTOForm);
        UserDTOView registered;

        try{
            registered = userService.register(userDTOForm);

        } catch (Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ex.getMessage(),
                    ex);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(registered);
    }


    @PutMapping("/")
    public ResponseEntity<Void> doUpdateUserExpiredByEmail(@RequestParam("email") String email, @RequestParam("expired") boolean expired){
        if (expired){
            userService.disableByEmail(email);
        } else {
            userService.enableByEmail(email);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
