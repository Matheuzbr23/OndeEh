package com.example.ondeeh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ondeeh.databinding.ActivityMainBinding
import com.example.ondeeh.model.Endereco
import com.example.ondeeh.ui.main.MainContract
import com.example.ondeeh.ui.main.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainPresenter: MainContract.MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mainPresenter = MainPresenter(this)
        setUpListener()
    }

    private fun setUpListener() {
        binding.btPesquisar.setOnClickListener {
            mainPresenter.pesquisar(binding.etCep.text.toString())
        }
    }

    override fun mostrarEndereco(endereco: Endereco?) {
        binding.tvLogradouro.text = endereco?.logradouro
        binding.tvBairro.text = endereco?.bairro
        binding.tvLocalidade.text = endereco?.localidade
        binding.tvUF.text = endereco?.uf
    }

    override fun mostrarErro(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
}