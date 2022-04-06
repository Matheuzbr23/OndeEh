package com.example.ondeeh.data.remote
import com.example.ondeeh.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoService {
    @GET("/ws/{cep}/json")
    fun pesquisar(@Path("cep") cep: String): Call<Endereco>
}