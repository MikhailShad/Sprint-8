package com.example.retailer.storage

import com.example.retailer.api.distributor.Item
import com.example.retailer.api.distributor.Order
import com.example.retailer.api.distributor.OrderInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item, Long>

@Repository
interface OrderRepository : JpaRepository<Order, String>

@Repository
interface OrderInfoRepository : JpaRepository<OrderInfo, String>
