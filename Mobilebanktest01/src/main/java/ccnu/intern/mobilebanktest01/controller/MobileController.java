package ccnu.intern.mobilebanktest01.controller;

import ccnu.intern.mobilebanktest01.pojo.Mobile;
import ccnu.intern.mobilebanktest01.pojo.ResponseBean;
import ccnu.intern.mobilebanktest01.service.IMobileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author intern
 * @since 2024-07-15
 */
@Controller
@RequestMapping("/mobile")
public class MobileController {
    @Autowired
    private IMobileService iMobileService;

    @PostMapping("/login")
    public ResponseBean<String> login( Mobile mobile) throws JsonProcessingException {
        return iMobileService.login(mobile);
    }



}
