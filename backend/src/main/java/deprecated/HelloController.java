package deprecated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import testapp.model.User;
import testapp.service.UserService;

import java.util.Iterator;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello-users")
    public String sayHello() {
        List<User> userList = userService.getAllUsers();
        Iterator<User> userIterator = userList.iterator();
        StringBuilder stringBuilder = new StringBuilder("Here are our users:\n");

        while (userIterator.hasNext()){
            stringBuilder.append(userIterator.next()).append("\n");
        }

        return stringBuilder.toString();
    }

    @GetMapping("/")
    public String mainMenu() {
        return "Hello everyone!";
    }
}
