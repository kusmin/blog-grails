package blog

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoComentarioController {

    TipoComentarioService tipoComentarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoComentarioService.list(params), model:[tipoComentarioCount: tipoComentarioService.count()]
    }

    def show(Long id) {
        respond tipoComentarioService.get(id)
    }

    def create() {
        respond new TipoComentario(params)
    }

    def save(TipoComentario tipoComentario) {
        if (tipoComentario == null) {
            notFound()
            return
        }

        try {
            tipoComentarioService.save(tipoComentario)
        } catch (ValidationException e) {
            respond tipoComentario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoComentario.label', default: 'TipoComentario'), tipoComentario.id])
                redirect tipoComentario
            }
            '*' { respond tipoComentario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoComentarioService.get(id)
    }

    def update(TipoComentario tipoComentario) {
        if (tipoComentario == null) {
            notFound()
            return
        }

        try {
            tipoComentarioService.save(tipoComentario)
        } catch (ValidationException e) {
            respond tipoComentario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoComentario.label', default: 'TipoComentario'), tipoComentario.id])
                redirect tipoComentario
            }
            '*'{ respond tipoComentario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tipoComentarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoComentario.label', default: 'TipoComentario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoComentario.label', default: 'TipoComentario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
