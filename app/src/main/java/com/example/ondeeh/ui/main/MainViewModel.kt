package com.example.ondeeh.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ondeeh.data.remote.APIService
import com.example.ondeeh.model.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val enderecoResponse = MutableLiveData<Endereco>()
    fun pesquisar(cep: String) {
        APIService.instance
            ?.pesquisar(cep)
            ?.enqueue(object: Callback<Endereco> {
                override fun onResponse(call: Call<Endereco>, response:
                Response<Endereco>
                ) {
                    if(response.isSuccessful) {
                        enderecoResponse.value = response.body()
                    } else {
                        enderecoResponse.value =
                            Endereco("N/A","N/A","N/A","N/A","N/A","N/A")
                    }
                }
                override fun onFailure(call: Call<Endereco>, t: Throwable) {
                    enderecoResponse.value =
                        Endereco("N/A","N/A","N/A","N/A","N/A","N/A")
                }
            })
    }
}