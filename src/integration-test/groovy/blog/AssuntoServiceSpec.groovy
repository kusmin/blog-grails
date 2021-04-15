package blog

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AssuntoServiceSpec extends Specification {

    AssuntoService assuntoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Assunto(...).save(flush: true, failOnError: true)
        //new Assunto(...).save(flush: true, failOnError: true)
        //Assunto assunto = new Assunto(...).save(flush: true, failOnError: true)
        //new Assunto(...).save(flush: true, failOnError: true)
        //new Assunto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //assunto.id
    }

    void "test get"() {
        setupData()

        expect:
        assuntoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Assunto> assuntoList = assuntoService.list(max: 2, offset: 2)

        then:
        assuntoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        assuntoService.count() == 5
    }

    void "test delete"() {
        Long assuntoId = setupData()

        expect:
        assuntoService.count() == 5

        when:
        assuntoService.delete(assuntoId)
        sessionFactory.currentSession.flush()

        then:
        assuntoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Assunto assunto = new Assunto()
        assuntoService.save(assunto)

        then:
        assunto.id != null
    }
}
