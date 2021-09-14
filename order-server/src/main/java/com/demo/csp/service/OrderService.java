package com.demo.csp.service;


import com.demo.csp.entity.CommonResult;
import com.demo.csp.entity.Order;

/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2021/9/7 14:04
 * @Created by Wu Zhi Qiang
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param order
     */
    public CommonResult createOrder(Order order);
}
