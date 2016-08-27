class BootStrap {

    def init = { servletContext ->
        String.metaClass.asFriendlyUrl = { ->
            friendlyUrlService.sanitizeWithDashes(delegate)
        }
    }
    def destroy = {
    }
}
