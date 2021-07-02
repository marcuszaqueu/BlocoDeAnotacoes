package br.com.mz.notes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.mz.notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Nota = ClassAnotacao(applicationContext)
        val bottonSave = binding.fab

        bottonSave.setOnClickListener {
            val anotacaoRecuperada = binding.editContainer.editBloco.text.toString()

            if(anotacaoRecuperada == ""){
                Toast.makeText(this,"Digite uma nota...", Toast.LENGTH_SHORT).show()
            }else{
                Nota.SalvarNota(anotacaoRecuperada)
                Toast.makeText(this,"Nota salva com sucesso!", Toast.LENGTH_SHORT).show()

            }
        }

        val recuperaAnotacao = Nota.RecuperaNota()
        if(recuperaAnotacao != ""){
            binding.editContainer.editBloco.setText(recuperaAnotacao)
        }

    }

}