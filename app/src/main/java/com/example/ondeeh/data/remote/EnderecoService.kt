package com.example.ondeeh.data.remote
import com.example.ondeeh.model.Endereco

interface EnderecoService {
    @GET("/ws/{cep}/json")
    fun pesquisar(@Path("cep") cep: String): Call<Endereco>
}