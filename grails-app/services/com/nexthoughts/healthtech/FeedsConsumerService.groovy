package com.nexthoughts.healthtech

import grails.transaction.Transactional

@Transactional
class FeedsConsumerService {
    static rabbitSubscribe = [name: "fetch", routingKey: "fetch.feed"]

    /*void handleMessage(SignupMailMessage message) {
        println message.properties
        try {
            rabbitMQEmailExchangeHelperService.sendSignupMail(message)
        } catch (Exception e) {
            prettyExceptionService.flush("Exception while sending signup mail", e)
            println "Handling exception at consumer"
        }
    }*/
}
