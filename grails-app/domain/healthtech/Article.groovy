package healthtech

class Article {

    String title
    String link
    String description
    Boolean isDeleted=Boolean.FALSE

    Date dateCreated
    Date lastUpdated

    def beforeValidate() {
        if (!link) link = title?.asFriendlyUrl()
    }

    static belongsTo = [author:Author]

    static constraints = {
    }
}
