package com.example.retailer.storage.impl


import com.example.retailer.api.distributor.Order
import com.example.retailer.api.distributor.OrderInfo
import com.example.retailer.api.distributor.OrderStatus
import com.example.retailer.storage.OrderStorage
import com.example.retailer.storage.PlaceOrderData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component

@Component
class OrderStorageImpl : OrderStorage {

    @Autowired
    lateinit var orderRepository: CrudRepository<Order, String>

    @Autowired
    lateinit var orderInfoRepository: CrudRepository<OrderInfo, String>

    override fun createOrder(draftOrder: Order): PlaceOrderData {
        val order = orderRepository.save(draftOrder)
        val orderInfo = orderInfoRepository.save(OrderInfo(order.id!!, OrderStatus.SENT, order.hashCode().toString()))

        return PlaceOrderData(order, orderInfo)
    }

    override fun getOrderInfo(id: String): OrderInfo? {
        val orderInfo = orderInfoRepository.findById(id)
        if (orderInfo.isEmpty) {
            return null
        }

        return orderInfo.get()
    }

    override fun updateOrder(order: OrderInfo): Boolean {
        if (orderInfoRepository.findById(order.orderId).isEmpty) {
            return false
        }

        orderInfoRepository.save(order)
        return true
    }
}
