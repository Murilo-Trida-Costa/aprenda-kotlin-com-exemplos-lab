enum class Nivel { BASICO, INTERMEDIARIO, AVACADO }

class Aluno(val nome: String, val idade: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel,) {

    val inscritos = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        //Adiciona os usuários passados para os inscritos
        inscritos.addAll(alunos)
    }
}

fun main() {
    //Criando uma lista para realizar a passagem para formação
    val conteudoseducacionais = listOf<ConteudoEducacional>(
        ConteudoEducacional("Introdução ao Kotlin", 40, Nivel.BASICO),
        ConteudoEducacional("Funções Kotlin", 50, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Tratamento de Exeções", 45, Nivel.AVACADO)
    )

    //Instnaciando a formaçãs
    val formacao = Formacao("Bootcamp Mobile", conteudoseducacionais, Nivel.INTERMEDIARIO)

    //Adicionando varios alunos na lista de inscrtios
    formacao.matricular(
        Aluno("Murilo", 16),
        Aluno("Maria", 19),
        Aluno("Fernando", 45),
        Aluno("Venilton", 40)
    )

    //Passando apenas um aluna para matricular
    formacao.matricular(
        Aluno("Jonas", 25)
    )

    //Saída das informações dos objetos
    println("Nome da formação: ${formacao.nome}") //Saída do nome

    println()

    println("Nivel: ${formacao.nivel}") //Saída do nivel

    println()

    //Saida dos conteutos educacinais de formação
    for(c: ConteudoEducacional in formacao.conteudos){
        println("Nome: ${c.nome} | Duração: ${c.duracao} | Nivel: ${c.nivel}")
    }

    println()

    //Saida dos usuários inscritos da formação
    for(s: Aluno in formacao.inscritos){
        println("Nome: ${s.nome} | Idade: ${s.idade}")
    }


}
