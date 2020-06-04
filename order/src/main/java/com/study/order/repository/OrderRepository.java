package com.study.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.study.order.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
