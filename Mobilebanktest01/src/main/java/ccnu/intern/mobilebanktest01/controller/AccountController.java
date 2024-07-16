package ccnu.intern.mobilebanktest01.controller;

import ccnu.intern.mobilebanktest01.mapper.AccountMapper;
import ccnu.intern.mobilebanktest01.pojo.Account;
import ccnu.intern.mobilebanktest01.pojo.ResponseBean;
import ccnu.intern.mobilebanktest01.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author intern
 * @since 2024-07-15
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService as;


//  按手机号查询关联账户
    @GetMapping("/findRelatedAccountByTel")
    public ResponseBean<List<Account>> findRelatedAccountByTel(String telephone) {

        return as.findRelatedAccountByTel(telephone);
    }

    //  按手机号查询未关联过的账户
    @GetMapping("/findUnRelatedAccountByTel")
    public ResponseBean<List<Account>> findUnRelatedAccountByTel(String telephone) {
        return as.findUnRelatedAccountByTel(telephone);
    }
    //  按账号ID查询账号信息
    @GetMapping("/searchByAccountId")
    public ResponseBean<Account> searchByAccountId(Integer accountId){
        return as.searchByAccountId(accountId);
    }
}
