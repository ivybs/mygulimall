package com.ibs.gulimall.order.dao;

import com.ibs.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ibs
 * @email ivybsugarman@qq.com
 * @date 2022-05-15 20:54:45
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
