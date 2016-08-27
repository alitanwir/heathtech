package healthtech

class Article {

    String title
    String link
    String description
    Boolean isDeleted=Boolean.FALSE

    Date dateCreated
    Date lastUpdated

    static belongsTo = [author:Author]

    static constraints = {
    }
}
