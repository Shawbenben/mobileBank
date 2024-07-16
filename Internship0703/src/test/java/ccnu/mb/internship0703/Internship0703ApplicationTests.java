package ccnu.mb.internship0703;

import ccnu.mb.internship0703.mapper.UserMapper;
import ccnu.mb.internship0703.pojo.User;
import ccnu.mb.internship0703.uitls.TokenUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Internship0703ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        User user = users.get(1);
        System.out.println(TokenUtils.getToken(user));
//        User user = new User();
//        user.setUsername("xx");
//        user.setAge(8);
//        user.setPassword("1234");
//        int result = userMapper.insert(user);
//        if(result>0){
//
//            System.out.println("成功");
//        }else{
//            System.out.println("失败");
//        }
    }

}
