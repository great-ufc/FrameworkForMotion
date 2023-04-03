package br.ufc.POC1.model.dao.interfaces

import br.ufc.POC1.model.dao.DBEntities.Pessoa

interface IPessoaRepository {
    fun Add(pessoa: Pessoa)
    fun GetPersonById(id: Int): Pessoa
    fun getAll(): MutableList<Pessoa>
}