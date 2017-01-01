package grails.sandbox

class BootStrap {

    def init = { servletContext ->
        // create a test user for our convenience
        new User(fullname: "Test User", email:"test@test.com",
                hash:"\$2a\$06\$bXZgXYru5o1rDhQXcBpBLeh8yhMzEKUimbFhqEQl8jYZbF/P.ruRm").save()
    }
    def destroy = {
    }
}
