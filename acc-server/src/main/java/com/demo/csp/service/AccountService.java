package com.demo.csp.service;


import com.demo.csp.entity.CommonResult;

import java.math.BigDecimal;

/**
 * @author clay
 * @version 1.0
 */
public interface AccountService {

    public CommonResult decrease(Long userId, BigDecimal money);

}
