package blog

class Post {
    String titulo
    Date dataPublicacao
    String conteudo

    static belongsTo = [
        categoria:Categoria
    ]

    static constraints = {
        titulo nullable:false, blank:false, maxSize:128
        dataPublicacao nullable:false
        conteudo nullable:false, maxSize:16384
        categoria nullable:false
    }
}