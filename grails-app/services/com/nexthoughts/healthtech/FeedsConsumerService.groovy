package com.nexthoughts.healthtech

import grails.transaction.Transactional
import healthfeeds.FeedRecord
import healthtech.Article
import healthtech.Author

@Transactional
class FeedsConsumerService {
    static rabbitSubscribe = [name: "fetch", routingKey: "fetch.feed"]

    void handleMessage(Map message) {
        Article.withNewSession {
           Author author= Author.get(message?.authorId)
            Article article=new Article(message?.feed,author).save(flush: true)
        }

    }
}
