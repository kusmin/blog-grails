package blog

import grails.gorm.services.Service

@Service(Assunto)
interface AssuntoService {

    Assunto get(Serializable id)

    List<Assunto> list(Map args)

    Long count()

    void delete(Serializable id)

    Assunto save(Assunto assunto)

}