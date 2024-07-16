package ccnu.mb.internship0702.controllers;

import ccnu.mb.internship0702.pojo.User;
import ccnu.mb.internship0702.services.UserService;
import ccnu.mb.internship0702.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private String default_name = "bb";
    private String default_password="1234";
    @Autowired
    private UserService userService;

    @PostMapping("/regsiter")
    public String regsiter(){
        return "--regsiter";
    }

    @RequestMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest request){
        String message = "";
        if(user.getUsername().equals(default_name) && user.getPassword().equals(default_password)){
            HttpSession session = request.getSession();
            session.setAttribute(default_name,user);
            message = "--login sessece--";
            System.out.println("--login sessece--");

            return new ResponseUtil("404",message,user);
        }else{
            System.out.println("login fail");
        }
        return null;
    }

    @PostMapping("updateInfo")
    public String updateInfo(){
        return "--updateInfo--";
    }

    @RequestMapping("/logout")
    public Object logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute(default_name);
        System.out.println("louhout");
        return null;
    }

//    @PostMapping("queryAll")
//    public Object queryAll(){
//        User user1 = new User("Tom","boy",18);
//        User user2 = new User("xixi","girl",20);
//        List<User> all = new LinkedList<User>();
//        all.add(user1);
//        all.add(user2);
//        return all;
//    }
}
