package healthtech

class Comment {

    String comment
    Boolean isDeleted=Boolean.FALSE

    Date dateCreated
    Date lastUpdated

    static belongsTo = [author:Author]

    static constraints = {
    }
}
