package healthtech

class Comment {

    String comment
    Boolean isDeleted

    Date dateCreated
    Date lastUpdated

    static belongsTo = [author:Author]

    static constraints = {
    }
}
