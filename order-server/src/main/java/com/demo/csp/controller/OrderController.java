package com.demo.csp.controller;

import com.demo.csp.entity.CommonResult;
import com.demo.csp.entity.Order;
import com.demo.csp.entity.OrderStatus;
import com.demo.csp.repository.OrderRepository;
import com.demo.csp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/9/7 9:58
 * @Created by Wu Zhi Qiang
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Order addOrder(){

        Order order = new Order();
        order.setProductId(1L);
        order.setUserId(1L);
        order.setStatus(OrderStatus.CREATING.getValue());
        order.setMoney(new BigDecimal(3));
        order.setCount(3L);
        Order save = orderRepository.save(order);
        return save;
    }

    @RequestMapping(value = "/getByOrderId",method = RequestMethod.GET)
    public Order getOrderById(String id){

        Order storage = orderRepository.getOne(1L);
        return storage;
    }

    @RequestMapping(value = "/getOrders",method = RequestMethod.GET)
    public List<Order> getOrders(){

        List<Order> all = orderRepository.findAll();

        return all;
    }

    @GetMapping("/create")
    public CommonResult createOrder(Order order) {
        return orderService.createOrder(order);
    }


}
