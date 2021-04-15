package blog

class Assunto {

    String nome

    static belongsTo = [categoria:Categoria]

    static constraints = {
        nome nullable:false, blank:false, unique:true, maxSize:256
    }
}
