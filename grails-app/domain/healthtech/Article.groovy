package healthtech

class Article {

    String title
    String link
    String description
    Boolean isDeleted

    Date dateCreated
    Date lastUpdated

    static belongsTo = [author:Author]

    static constraints = {
    }
}
