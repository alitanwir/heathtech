package healthtech

class Article {

    String title
    String link
    String description
    Date datePublished
    Boolean isDeleted=Boolean.FALSE

    Date dateCreated
    Date lastUpdated

    static belongsTo = [author:Author]

    static constraints = {
        title unique: true

    }
}
