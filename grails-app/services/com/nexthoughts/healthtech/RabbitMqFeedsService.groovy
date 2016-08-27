package com.nexthoughts.healthtech

import grails.transaction.Transactional

@Transactional
class RabbitMqFeedsService {

    static rabbitSubscribe = [name: "fetch", routingKey: "fetch.feed"]

    def fetchFeeds() {

    }
}
