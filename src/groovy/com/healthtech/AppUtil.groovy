package com.healthtech

class AppUtil {

    static Boolean save(def object) {
        Boolean result = false
        if (object.validate() && !object.hasErrors() && object.save(flush: true)) {
            result = true
        } else {
            object.errors.allErrors.each {
                println '----------------------' + it
            }
            result = false
        }
        return result
    }
}
