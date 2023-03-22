package br.ufc.frameworkkotlin.model.dao.interfaces

import br.ufc.frameworkkotlin.model.dao.DBEntities.Pessoa

interface IPessoaRepository {
    fun Add(pessoa: Pessoa)
    fun GetPersonById(id: Int): Pessoa
    fun getAll(): MutableList<Pessoa>
}