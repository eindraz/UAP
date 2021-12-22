package com.wahyuindra.uap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_mahasiswa_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class MahasiswaAddFragment : Fragment() {

    private var nimInput : String = ""
    private var namaInput : String = ""
    private var prodiInput : String = ""
    private var alamatInput : String = ""

    private var db: AppDatabase? = null
    private var vMahasiswaDao: MahasiswaDao? = null

    companion object {
        fun newInstance(): MahasiswaAddFragment {
            return MahasiswaAddFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mahasiswa_add, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        vMahasiswaDao = db?.MahasiswaDao()
    }

    private fun initView() {
        btnSave.setOnClickListener { validasiInput() }
    }

    private fun validasiInput() {
        nimInput = edtNIM.text.toString()
        namaInput = edtNama.text.toString()
        prodiInput = edtProdi.text.toString()
        alamatInput = edtAlamat.text.toString()

        when{
            nimInput.isEmpty() -> edtNIM.error = "NIM tidak boleh kosong"
            namaInput.isEmpty() -> edtNama.error = "Nama tidak boleh kosong"

            prodiInput.isEmpty() -> edtProdi.error = "Prodi tidak boleh kosong"
            alamatInput.isEmpty() -> edtAlamat.error = "Alamat tidak boleh kosong"

            else -> {

                val mahasiswa = Mahasiswa(nim = nimInput,nama = namaInput, prodi = prodiInput, alamat = alamatInput)
                tambahDataMahasiswa(mahasiswa)

            }
        }

    }

    private fun tambahDataMahasiswa(mahasiswa: Mahasiswa) : Job {

        return GlobalScope.launch {
            vMahasiswaDao?.tambahMahasiswa(mahasiswa)
            (activity as MainActivity).tampilMahasiswaFragment()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}