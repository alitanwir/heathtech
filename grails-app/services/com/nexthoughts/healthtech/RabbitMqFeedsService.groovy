package com.nexthoughts.healthtech

import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class RabbitMqFeedsService {
    def feedsService
    def grailsApplication

   void fetchFeeds(){
       String url1=grailsApplication.config.feeds.url1
       println url1
       List feedsList=feedsService.getfeed(url1)
       feedsList.each{
           int index = Math.abs(new Random().nextInt() % 500) + 1
           rabbitSend "fetch","fetch.feed",[feed:it,authorId:index]
       }
   }
}
