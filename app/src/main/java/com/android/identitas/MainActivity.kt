package com.android.identitas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.identitas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            showCombinedText()
        }
    }

    private fun showCombinedText() {
        val nama = binding.etNama.text.toString()
        val alamat = binding.etAlamat.text.toString()

        val jenisKelamin = when {
            binding.rbPria.isChecked -> "Pria"
            binding.rbWanita.isChecked -> "Wanita"
            else -> "Belum dipilih"
        }

        val pendidikan = when {
            binding.rbSD.isChecked -> "SD"
            binding.rbSMP.isChecked -> "SMP"
            binding.rbSMA.isChecked -> "SMA"
            binding.rbPT.isChecked -> "PT"
            else -> "Belum dipilih"
        }

        val identitas = mutableListOf<String>()
        if (binding.cbKTP.isChecked) identitas.add("KTP")
        if (binding.cbSIM.isChecked) identitas.add("SIM")
        if (binding.cbPaspor.isChecked) identitas.add("PASPOR")

        val ciriFisik = mutableListOf<String>()
        if (binding.cbGendorong.isChecked) ciriFisik.add("Gendorong")
        if (binding.cbTinggi.isChecked) ciriFisik.add("Tinggi")
        if (binding.cbGanteng.isChecked) ciriFisik.add("Ganteng")

        val combinedText = """
            Nama: $nama
            Alamat: $alamat
            Jenis Kelamin: $jenisKelamin
            Pendidikan: $pendidikan
            Identitas: ${identitas.joinToString(", ")}
            Ciri Fisik: ${ciriFisik.joinToString(", ")}
        """.trimIndent()

        binding.tvHasil.text = combinedText
    }
}