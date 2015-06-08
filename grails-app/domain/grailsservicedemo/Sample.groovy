package grailsservicedemo

class Sample {
    String name
    String content

    static constraints = {
        content nullable: false, blank: false
    }
}
