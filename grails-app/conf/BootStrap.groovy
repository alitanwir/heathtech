class BootStrap {

    def friendlyUrlService

    def init = { servletContext ->
        String.metaClass.asFriendlyUrl = { ->
            friendlyUrlService.sanitizeWithDashes(delegate)
        }
    }
    def destroy = {
    }
}
