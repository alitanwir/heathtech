package com.nexthoughts.healthtech

import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class RabbitMqFeedsService {
    def feedsService
    def grailsApplication

   void fetchFeeds(){
       String url1=grailsApplication.config.feeds.url1
       List feedsList=feedsService.getfeed(url1)
       println feedsList
   }
}
