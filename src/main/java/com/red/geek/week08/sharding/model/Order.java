package com.red.geek.week08.sharding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order
 *
 * @author red
 * @class_name Order
 * @date 2021-05-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private Long userId;
}
