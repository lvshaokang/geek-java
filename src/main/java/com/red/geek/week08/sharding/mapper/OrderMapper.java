package com.red.geek.week08.sharding.mapper;

import com.red.geek.week08.sharding.model.Order;
import org.springframework.stereotype.Repository;

/**
 * @author red
 * @class_name OrderMapper
 * @date 2021-05-23
 */
@Repository
public interface OrderMapper {
    void insertOne(Order order);
    void delete(Long id);
    void update(Order order);
}
