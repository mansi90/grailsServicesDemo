package grailsservicedemo

class DemoController {
    def demoService

    def index() {
        Sample sample = createOneObject()
        printValues(sample)
        demoService.fiddle(sample.id, 100)
        printValues(sample)
    }

    def createOneObject() {
        if (!Sample.count())
            new Sample(name: 'TEST1', content: 'ABCDE').save(flush: true)
    }

    def printValues(Sample sample) {
        println("Total Objects > " + Sample.count())
        println("Object 1 > Content > " + sample.content)
    }
}
