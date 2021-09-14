package com.demo.csp.controller;

import com.demo.csp.entity.Account;
import com.demo.csp.entity.CommonResult;
import com.demo.csp.repository.AccountRepository;
import com.demo.csp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/9/7 9:58
 * @Created by Wu Zhi Qiang
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Account addAccount(){

        Account account = new Account();
        account.setResidue(new BigDecimal(1000));
        account.setTotal(new BigDecimal(1000));
        account.setUsed(new BigDecimal(0));
        account.setUserId(1L);
        Account save = accountRepository.save(account);
        return save;
    }

    @RequestMapping(value = "/getAccountId",method = RequestMethod.GET)
    public Account getAccountById(String id){

        Account account = accountRepository.getOne(1L);
        return account;
    }

    @PostMapping("/decrease")
    public CommonResult decrease(Long userId, BigDecimal money) {
        Account account = new Account();
        account.setResidue(new BigDecimal(1000));
        account.setTotal(new BigDecimal(1000));
        account.setUsed(new BigDecimal(0));
        account.setUserId(1L);
        Account save = accountRepository.save(account);
        return accountService.decrease(userId, money);
    }

}
