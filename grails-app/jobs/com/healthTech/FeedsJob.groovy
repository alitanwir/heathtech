package com.healthTech



class FeedsJob {

    def rabbitMqFeedsService

    static triggers = {
        cron cronExpression: "0 0 17 1/1 * ? *"
    }

    def execute() {
        log.info("###############################################################################")
        log.info("###############################################################################")
        log.info("Triggering RabbitMq Server to fetch feeds and data")
        log.info("###############################################################################")
        rabbitMqFeedsService
        log.info("###############################################################################")

    }
}
