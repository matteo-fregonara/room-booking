package nl.tudelft.sem.template.controllers;

import nl.tudelft.sem.template.entities.User;
import nl.tudelft.sem.template.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "")
public class UserController {
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private transient UserRepository userRepository;

    /**
     * Gets a list of all users.
     *
     * @return an iterable of users.
     */
    @GetMapping(path = "/getAll")
    @PreAuthorize("hasRole('TEACHER')")
    public @ResponseBody
    Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

}

