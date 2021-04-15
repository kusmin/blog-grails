package blog

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AssuntoController {

    AssuntoService assuntoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond assuntoService.list(params), model:[assuntoCount: assuntoService.count()]
    }

    def show(Long id) {
        respond assuntoService.get(id)
    }

    def create() {
        respond new Assunto(params)
    }

    def save(Assunto assunto) {
        if (assunto == null) {
            notFound()
            return
        }

        try {
            assuntoService.save(assunto)
        } catch (ValidationException e) {
            respond assunto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'assunto.label', default: 'Assunto'), assunto.id])
                redirect assunto
            }
            '*' { respond assunto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond assuntoService.get(id)
    }

    def update(Assunto assunto) {
        if (assunto == null) {
            notFound()
            return
        }

        try {
            assuntoService.save(assunto)
        } catch (ValidationException e) {
            respond assunto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'assunto.label', default: 'Assunto'), assunto.id])
                redirect assunto
            }
            '*'{ respond assunto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        assuntoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'assunto.label', default: 'Assunto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'assunto.label', default: 'Assunto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
