package healthtech

class Author {

    String firstName
    String lastName

    Date dateCreated
    Date lastUpdated

    Boolean isDeleted

    static hasMany = [articles: Article, authors: Author, followers: Follower]

    static constraints = {
    }
}
