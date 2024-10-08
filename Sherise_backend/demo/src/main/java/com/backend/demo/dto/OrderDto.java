package com.backend.demo.dto;

import com.backend.demo.enums.OrderStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {



    private Long id;

    private String orderDescription;
    private Date date;
    private Long amount;
    private String address;
    private String payment;
    private OrderStatus orderStatus;
    private Long totalAmount;
    private Long discount;
    private UUID trackingId;
    private String RazorpayOrderId;


    private String userName;

    private List<CartItemsDto> cartItems;

    private String couponName;
}
