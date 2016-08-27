package com.nexthoughts.healthtech

import grails.plugin.springsecurity.annotation.Secured


@Secured("permitAll")
class PublicController {

    def rabbitMqFeedsService
    def index() {
        render rabbitMqFeedsService.fetchFeeds()
    }
}
