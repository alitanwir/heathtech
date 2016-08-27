class BootStrap {

    def friendlyUrlService
    def bootstrapService

    def init = { servletContext ->
        String.metaClass.asFriendlyUrl = { ->
            friendlyUrlService.sanitizeWithDashes(delegate)
        }

        bootstrapService.createAdmin()
        bootstrapService.createAuthors()
    }
    def destroy = {
    }
}
