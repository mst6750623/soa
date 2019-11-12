package com.soa.accountservice.controller;

import com.soa.accountservice.Service.AccountService;
import com.soa.accountservice.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.hibernate.cache.spi.AbstractCacheTransactionSynchronization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    //新建账户
    @PostMapping("/Account")
    public Sign_up_Result CreateNew(@RequestBody Sign_up_params sign_up_params) {
        Account account=new Account();
        account.setAccount(sign_up_params.getAccount());
        account.setPwd(sign_up_params.getPwd());
        account.setRole(sign_up_params.getRole());
        accountService.save(account);
        Sign_up_Result result=new Sign_up_Result();
        result.setId(account.getAccount());
        result.setSucceed(true);
        result.setWrongCode(0);
        return result;
    }

    //查询账户
    @GetMapping("/Account")
    public AccountInfo QueryAccount(@RequestParam(value = "id") String id) {
        Account account=new Account();
        account=accountService.findById(id);
        AccountInfo accountInfo=new AccountInfo();
        accountInfo.setId(account.get_id());
        accountInfo.setAccount(account.getAccount());
        accountInfo.setPwd(account.getPwd());
        accountInfo.setRole(account.getRole());
        return accountInfo;
    }

    //修改账户
    @PutMapping("/Account")
    public Stand_Result Update(@RequestBody LoginParams loginParams) {
        return null;
    }

    //删除账户
    @DeleteMapping("/Account/{id}")
    public Stand_Result Delete(@PathVariable("_id") String _id) {
        accountService.delete(_id);
        Stand_Result result=new Stand_Result();
        result.setSucceed(true);
        result.setWrongCode("0");
        return result;
    }

}
