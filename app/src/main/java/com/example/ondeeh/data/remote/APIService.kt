package com.example.ondeeh.data.remote

object APIService {
    private var INSTANCE: EnderecoService ? = null
    val instance: EnderecoService ?
        get() {
            if(INSTANCE == null) {
                val client = OkHttpClient .Builder()
                    .build()
                val retrofit = Retrofit.Builder()
                    .baseUrl( "https://viacep.com.br" )

                    .addConverterFactory( MoshiConverterFactory .create())
                    .client( client)
                    .build()
                INSTANCE =
                    retrofit.create(EnderecoService ::class.java)
            }
            return INSTANCE
        }
