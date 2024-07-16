package ccnu.mb.internship0702.services;


import ccnu.mb.internship0702.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Override
    public User login(User user){
        System.out.println(user);
        return null;
    }

}
