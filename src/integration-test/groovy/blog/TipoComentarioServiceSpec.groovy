package blog

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoComentarioServiceSpec extends Specification {

    TipoComentarioService tipoComentarioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoComentario(...).save(flush: true, failOnError: true)
        //new TipoComentario(...).save(flush: true, failOnError: true)
        //TipoComentario tipoComentario = new TipoComentario(...).save(flush: true, failOnError: true)
        //new TipoComentario(...).save(flush: true, failOnError: true)
        //new TipoComentario(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoComentario.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoComentarioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoComentario> tipoComentarioList = tipoComentarioService.list(max: 2, offset: 2)

        then:
        tipoComentarioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoComentarioService.count() == 5
    }

    void "test delete"() {
        Long tipoComentarioId = setupData()

        expect:
        tipoComentarioService.count() == 5

        when:
        tipoComentarioService.delete(tipoComentarioId)
        sessionFactory.currentSession.flush()

        then:
        tipoComentarioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoComentario tipoComentario = new TipoComentario()
        tipoComentarioService.save(tipoComentario)

        then:
        tipoComentario.id != null
    }
}
