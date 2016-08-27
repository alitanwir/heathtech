package com.nexthoughts.healthtech

import grails.transaction.Transactional
import healthfeeds.FeedRecord
import healthtech.Article
import healthtech.Author

@Transactional
class FeedsConsumerService {
    static rabbitSubscribe = [name: "fetch", routingKey: "fetch.feed"]

    void handleMessage(Map feedMap) {
        Article.withNewSession {
           Author author= Author.get(feedMap.customerId)
            Article article=new Article(feedMap.feed,author).save(flush: true)
        }

    }
}
