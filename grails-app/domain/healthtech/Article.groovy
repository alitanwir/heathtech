package healthtech

import healthfeeds.FeedRecord

class Article {

    String title
    String link
    String description
    Date datePublished
    Boolean isDeleted=Boolean.FALSE

    Date dateCreated
    Date lastUpdated

    static hasMany = [comments:Comment]


    static belongsTo = [author:Author]

    static constraints = {
        title unique: true
        link nullable:true

    }

    static mapping = {
        description type: "text" }

    Article(FeedRecord feed,Author author){
        this.title=feed?.title
        this.link=feed?.link
        this.description=feed?.description
        this.datePublished=feed.datePublish
        this.author=author
    }
}
