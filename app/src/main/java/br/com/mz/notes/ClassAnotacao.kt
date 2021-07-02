package br.com.mz.notes

import android.content.Context
import android.content.SharedPreferences

class ClassAnotacao(private val context: Context) {

    private val Arquivo = "anotacao.preferencia"
    private val KEY = "nome"
    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    fun SalvarNota(anotacao: String?){
        editor.putString(KEY,anotacao)
        editor.commit()

    }

    fun RecuperaNota(): String?{
        return preferences.getString(KEY,"")
    }

    init{
        preferences = context.getSharedPreferences(Arquivo,0)
        editor = preferences.edit()
    }

}