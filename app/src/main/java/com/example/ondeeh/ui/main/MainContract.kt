package com.example.ondeeh.ui.main

import com.example.ondeeh.model.Endereco

interface MainContract {
    interface MainView {
        fun mostrarEndereco(endereco: Endereco?)
        fun mostrarErro(mensagem: String)
    }
    interface MainPresenter {
        fun pesquisar(cep: String)
    }
}