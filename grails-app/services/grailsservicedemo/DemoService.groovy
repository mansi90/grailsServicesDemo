package grailsservicedemo

import grails.transaction.Transactional

@Transactional
class DemoService {

    @Transactional
    def fiddle(Long id1, Long id2) {
        println('In Demo Service')
        def object1 = Sample.findById(id1)
        println(object1)
        object1.content = "A change"
        object1.save(flush: true) // will cause hibernate to perform the update statements

        def object2 = Sample.findById(id2) ?: new Sample()
        println(object2)

        object2.name = "TEST2"

        if (!object2.save(flush: true)) { // will also write to the db
            // This will throw an runtime exception and the transaction will be rolled back (i.e Object1's content property will remain unchanged.
            throw new RuntimeException("An exception occurred!")
        }
    }
}
