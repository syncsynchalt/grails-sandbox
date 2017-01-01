package grails.sandbox

class User {
    String fullname
    String email
    String hash

    String toString() {
        return "$email"
    }

    static constraints = {
        email email: true, blank: false, unique: true
        fullname blank: false
        hash blank: false
    }

    static mapping = {
        table 'appuser'
    }
}
