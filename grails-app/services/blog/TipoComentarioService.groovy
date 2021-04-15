package blog

import grails.gorm.services.Service

@Service(TipoComentario)
interface TipoComentarioService {

    TipoComentario get(Serializable id)

    List<TipoComentario> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoComentario save(TipoComentario tipoComentario)

}