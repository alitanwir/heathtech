package com.nexthoughts.healthtech

import grails.transaction.Transactional

@Transactional
class ScrapingConsumerService {

    static rabbitSubscribe = [name: "fetch", routingKey: "fetch.scrap"]

    def serviceMethod() {

    }
}
