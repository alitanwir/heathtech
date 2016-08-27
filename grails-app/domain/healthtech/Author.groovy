package healthtech

class Author {

    String firstName
    String lastName

    Date dateCreated
    Date lastUpdated

    Boolean isDeleted=Boolean.FALSE

    static hasMany = [articles: Article, comments: Comment, followers: Follower]

    static constraints = {
    }
}
