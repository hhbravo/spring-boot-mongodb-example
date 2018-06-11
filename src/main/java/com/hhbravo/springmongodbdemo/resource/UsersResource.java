package com.hhbravo.springmongodbdemo.resource;

import com.hhbravo.springmongodbdemo.document.Users;
import com.hhbravo.springmongodbdemo.repository.IUserRepository;
import com.hhbravo.springmongodbdemo.service.IUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersResource {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUsersService usersService;

    @GetMapping("/all")
    public List<Users> getAll() {
        LOG.info("All users.");
        return usersService.getAll();
    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable("id") String userId) {
        LOG.info("Get user.");
        return usersService.getById(Integer.parseInt(userId));
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public Users addNewUsers(@RequestBody Users user) {
        LOG.info("Saving user.");
        return usersService.create(user);
    }

}
