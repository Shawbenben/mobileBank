package ccnu.mb.internship0702.services;

import ccnu.mb.internship0702.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User login(User user);
}
