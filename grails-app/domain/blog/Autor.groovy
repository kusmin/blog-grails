package blog

class Autor {

    String nome
    String nacionalidade

    static hasMany = [post:Post]

    String toString() {
        this.nome
    }

    static constraints = {
        nome nullable:false, blank:false, maxSize:128, unique:true
        nacionalidade nullable:true
    }
}
