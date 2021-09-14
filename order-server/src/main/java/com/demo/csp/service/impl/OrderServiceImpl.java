package com.demo.csp.service.impl;


import com.demo.csp.client.AccountClient;
import com.demo.csp.client.StorageClient;
import com.demo.csp.entity.CommonResult;
import com.demo.csp.entity.Order;
import com.demo.csp.repository.OrderRepository;
import com.demo.csp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2021/9/7 14:05
 * @Created by Wu Zhi Qiang
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired(required = false)
    private AccountClient accountClient;

    @Autowired(required = false)
    private StorageClient storageClient;

    public CommonResult createOrder(Order order) {
        // 创建订单
        orderRepository.save(order);
        // 扣减商品库存
        storageClient.decrease(order.getProductId(), order.getCount());
        // 扣减账户余额
        accountClient.decrease(order.getUserId(), order.getMoney());
        //更新订单状态
         //orderMapper.update(order.getId(), OrderStatus.FINISHED.getValue());
        return new CommonResult();
    }
}
