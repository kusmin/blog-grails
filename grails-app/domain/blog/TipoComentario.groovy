package blog

class TipoComentario {

    String nome

    static hasMany = [comentario:Comentario]

    static constraints = {
        nome inList: ['pergunta', 'resposta', 'elogio', 'critica']
    }
}
