package com.example.retailer.api.distributor

import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.Table

/**
 * Уведомление об изменении заказа
 */
@Entity
@Table(name = "order_infos")
data class OrderInfo(

    /**
     * Уникальный идентификатор заказа
     *
     * @see com.example.retailer.api.distributor.Item#id
     */
    @Id
    val orderId: String,

    /**
     * Статус заказа:
     *  Created
     *
     */
    @Enumerated
    var status: OrderStatus,

    /**
     * Контрольная сумма
     */
    val signature: String,

    )
