package com.example.retailer.adapter.impl

import com.example.retailer.adapter.RetailerConsumer
import com.example.retailer.api.distributor.OrderInfo
import com.example.retailer.config.AmqpConfiguration.Companion.RETAILER_QUEUE
import com.example.retailer.storage.OrderStorage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class RetailerConsumerImpl(private val storage: OrderStorage) : RetailerConsumer {
    @RabbitListener(queues = [RETAILER_QUEUE])
    override fun receiveUpdate(orderInfo: OrderInfo) {
        storage.updateOrder(orderInfo)
    }
}
