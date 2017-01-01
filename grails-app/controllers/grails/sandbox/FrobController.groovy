package grails.sandbox

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FrobController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Frob.list(params), model:[frobCount: Frob.count()]
    }

    def show(Frob frob) {
        respond frob
    }

    @Transactional
    def save(Frob frob) {
        if (frob == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (frob.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond frob.errors, view:'create'
            return
        }

        frob.save flush:true

        respond frob, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Frob frob) {
        if (frob == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (frob.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond frob.errors, view:'edit'
            return
        }

        frob.save flush:true

        respond frob, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Frob frob) {

        if (frob == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        frob.delete flush:true

        render status: NO_CONTENT
    }
}
