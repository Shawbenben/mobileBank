package ccnu.intern.mobilebanktest01.service.impl;

import ccnu.intern.mobilebanktest01.pojo.Mobile;
import ccnu.intern.mobilebanktest01.mapper.MobileMapper;
import ccnu.intern.mobilebanktest01.pojo.ResponseBean;
import ccnu.intern.mobilebanktest01.service.IMobileService;
import ccnu.intern.mobilebanktest01.util.JWTTool;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author intern
 * @since 2024-07-15
 */
@Service
public class MobileServiceImpl extends ServiceImpl<MobileMapper, Mobile> implements IMobileService {
    @Autowired
    private MobileMapper mobileMapper;


    @Override
    public ResponseBean<String> login(Mobile mobile) throws JsonProcessingException {
        ResponseBean<String> rb = null;

        QueryWrapper<Mobile> qw = new QueryWrapper<>();
        qw.eq("telephone",mobile.getTelephone());
        Mobile result = mobileMapper.selectOne(qw);

        if(result == null){
            rb = new ResponseBean<>(801,"手机号错误");
        }else if(!result.getPassword().equals(mobile.getPassword())){
            rb = new ResponseBean<>(802,"密码错误");
        }else{
            ObjectMapper om = new ObjectMapper();
            result.setPassword(null);
            String json = om.writeValueAsString(result);
            String token = JWTTool.createToken(json);
            rb = new ResponseBean<>(token);
        }

        return rb;
    }

    @Override
    public ResponseBean<String> mylogin(String telephone, String password) throws JsonProcessingException {
        ResponseBean<String> rb = null;

        QueryWrapper<Mobile> qw = new QueryWrapper<>();
        qw.eq("telephone",telephone);
        Mobile result = mobileMapper.selectOne(qw);

        if(result == null){
            rb = new ResponseBean<>(801,"手机号错误");
        }else if(!result.getPassword().equals(password)){
            rb = new ResponseBean<>(802,"密码错误");
        }else{
            ObjectMapper om = new ObjectMapper();
            result.setPassword(null);
            String json = om.writeValueAsString(result);
            String token = JWTTool.createToken(json);
            rb = new ResponseBean<>(token);
        }

        return rb;
    }
}
