package com.demo.csp.service.impl;

import com.demo.csp.entity.Account;
import com.demo.csp.entity.CommonResult;
import com.demo.csp.entity.SystemCode;
import com.demo.csp.repository.AccountRepository;
import com.demo.csp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author clay
 * @version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public CommonResult decrease(Long userId, BigDecimal money) {
        Account account = accountRepository.getOne(1L);
        BigDecimal total = account.getTotal();
        BigDecimal used = account.getUsed();
        BigDecimal residue = account.getResidue();
        // 模拟业务处理超时
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        // 校验参数
        if (money == null || money.compareTo(BigDecimal.ZERO) < 1) {
            return new CommonResult(SystemCode.ERROR_PARAMETER);
        }
        // 判断余额是否足够
        if (money.compareTo(residue) == 1) {
            return new CommonResult(SystemCode.ACCOUNT_NOT_ENOUGH);
        }
        //
        // 扣减余额
        account.setUsed(account.getUsed().add(money));
        account.setResidue(account.getResidue().subtract(money));
        accountRepository.save(account);
        return new CommonResult();
    }
}
