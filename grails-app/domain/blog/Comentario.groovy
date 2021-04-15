package blog

class Comentario {

    String titulo
    String corpoDoComentario
    Boolean ativo = true

    static belongsTo = [tipoComentario:TipoComentario]

    static constraints = {
        titulo nullable:false, blank:false, unique:true
        corpoDoComentario nullable:false, minSize:16, blank:true
        tipoComentario nullable:false
    }
}
