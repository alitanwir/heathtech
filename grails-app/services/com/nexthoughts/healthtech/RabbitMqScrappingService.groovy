package com.nexthoughts.healthtech

import grails.transaction.Transactional

@Transactional
class RabbitMqScrappingService {

    static rabbitSubscribe = [name: "fetch", routingKey: "fetch.feed"]

    def fetchScrappingData() {

    }
}
