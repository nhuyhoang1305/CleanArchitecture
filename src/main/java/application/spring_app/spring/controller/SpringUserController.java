package application.spring_app.spring.controller;

import adapter.controller.UserController;
import adapter.controller.model.UserWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpringUserController {

    private final UserController controller;

    @Autowired
    public SpringUserController(final UserController controller) {
        this.controller = controller;
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome() {
        return "Welcome to Clean Architecture";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public UserWeb createUser(@RequestBody final UserWeb userWeb) {
        return controller.createUser(userWeb);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public UserWeb login(@RequestParam("email") final String email, @RequestParam("password") final String password) {
        return controller.login(email, password);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public UserWeb getUser(@PathVariable("userId") final String userId) {
        return controller.getUser(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserWeb> allUsers() {
        return controller.allUsers();
    }
}
