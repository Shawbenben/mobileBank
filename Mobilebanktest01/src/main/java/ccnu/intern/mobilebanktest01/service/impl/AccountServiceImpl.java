package ccnu.intern.mobilebanktest01.service.impl;

import ccnu.intern.mobilebanktest01.pojo.Account;
import ccnu.intern.mobilebanktest01.mapper.AccountMapper;
import ccnu.intern.mobilebanktest01.pojo.ResponseBean;
import ccnu.intern.mobilebanktest01.service.IAccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author intern
 * @since 2024-07-15
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    @Autowired
    private AccountMapper am;

    @Override
    public ResponseBean<List<Account>> findRelatedAccountByTel(String telephone)
    {
        // TODO Auto-generated method stub

        QueryWrapper<Account> qw=new QueryWrapper();
        qw.inSql("id", "SELECT accountId from mobileaccount");
        qw.inSql("personId", "select id from personinfo where telephone="+telephone);
                qw.eq("statusId", 1);
        List<Account> list=am.selectList(qw);
        ResponseBean<List<Account>> rb=null;
        if(list.size()>0){
            rb=new ResponseBean<>(list);
        }else{
            rb=new ResponseBean<>(810,"没有可以关联的账户");
        }
        return rb;
    }
    @Override
    public ResponseBean<List<Account>> findUnRelatedAccountByTel(String telephone) {
        // TODO Auto-generated method stub
        QueryWrapper<Account> qw=new QueryWrapper();
        qw.notInSql("id", "SELECT accountId from mobileaccount");
        qw.inSql("personId", "select id from personinfo where telephone="+telephone);
                qw.eq("statusId", 1);
        List<Account> list=am.selectList(qw);
        ResponseBean<List<Account>> rb=null;
        if(list.size()>0){
            rb=new ResponseBean<>(list);
        }else{
            rb=new ResponseBean<>(810,"没有可以关联的账户");
        }
        return rb;
    }
    @Override
    public ResponseBean<Integer> findStatusId(Map<String, String> con) {
        // TODO Auto-generated method stub
        QueryWrapper<Account> qw=new QueryWrapper<>();
        qw.eq("accountName", con.get("accountName"));
        qw.inSql("personId", "select id from personInfo where realname='"+con.get("realname")+"'");
                Account account=am.selectOne(qw);
        ResponseBean<Integer> rb=null;
        if(account!=null){
            Integer statusId=account.getStatusId();
            if(statusId>0){
                rb=new ResponseBean<>(statusId);
            }else{
                rb=new ResponseBean<>(801,"该账户已经冻结");
            }
        }else{
            rb=new ResponseBean<>(802,"账户和姓名不匹配");
        }
        return rb;
    }
    @Override
    public ResponseBean<Account> searchByAccountId(Integer accountId) {
        // TODO Auto-generated method stub
        QueryWrapper<Account> qw=new QueryWrapper();
        qw.eq("id", accountId);
        qw.select("accountName","balance");
        Account result=am.selectOne(qw);
        Account t1 =am.selectById(accountId);
        ResponseBean<Account> rb=new ResponseBean<>(t1);
        return rb;

    }
}
