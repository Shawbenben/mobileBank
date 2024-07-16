package ccnu.intern.mobilebanktest01.service;

import ccnu.intern.mobilebanktest01.pojo.Account;
import ccnu.intern.mobilebanktest01.pojo.ResponseBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author intern
 * @since 2024-07-15
 */
public interface IAccountService extends IService<Account> {

    //  按手机号查询关联账户
    public ResponseBean<List<Account>> findRelatedAccountByTel(String telephone);
    //  按手机号查询未关联过的账户
    public ResponseBean<List<Account>> findUnRelatedAccountByTel(String telephone);
    //  按账号和客户真实姓名查询账户是否有效
    public ResponseBean<Integer> findStatusId(Map<String,String> con);

    //  按账号ID查询账号信息
    public ResponseBean<Account> searchByAccountId(Integer accountId);

}
