package ccnu.intern.mobilebanktest01.service;

import ccnu.intern.mobilebanktest01.pojo.Mobile;
import ccnu.intern.mobilebanktest01.pojo.ResponseBean;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author intern
 * @since 2024-07-15
 */
public interface IMobileService extends IService<Mobile> {
    public ResponseBean<String> login(Mobile mobile) throws JsonProcessingException;

    public ResponseBean<String> mylogin(String telephone, String password) throws JsonProcessingException;
}
