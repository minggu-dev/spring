package com.study.goods.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.goods.domain.Goods;

@Repository
public interface GoodsRepository extends CrudRepository<Goods, Long> {

}
