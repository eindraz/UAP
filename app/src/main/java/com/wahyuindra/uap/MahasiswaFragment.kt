package com.wahyuindra.uap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_mahasiswa.*

class MahasiswaFragment : Fragment() {

    private var arrMahasiswa : MutableList<Mahasiswa>? = null

    private var db: AppDatabase? = null
    private var vMahasiswaDao: MahasiswaDao? = null

    companion object {
        fun newInstance(): MahasiswaFragment {
            return MahasiswaFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mahasiswa, container, false)
        initLocalDB()
        initView()
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        vMahasiswaDao = db?.MahasiswaDao()
    }

//    private fun simulasiDataMahasiswa() {
//        arrMahasiswa = ArrayList()
//
//        arrMahasiswa.add(Mahasiswa(1, "21510018","Wahyu Indra", "S1 Sistem Informasi", "Singosari"))
//        arrMahasiswa.add(Mahasiswa(2,"21510001", "Coba", "S1 Tenik Informatika", "Malang",))
//
//    }

    private fun initView() {
        //simulasiDataMahasiswa()
        //tampilMahasiswa()
        ambilDataMahasiswa()
    }

    private fun ambilDataMahasiswa() {

        arrMahasiswa = ArrayList()
        vMahasiswaDao?.ambilSemuaMahasiswa()?.observe(viewLifecycleOwner, Observer { r ->

            arrMahasiswa = r as MutableList<Mahasiswa>?

            when {
                arrMahasiswa?.size == 0 -> tampilToast("Belum ada data Handphone")

                else -> {
                    tampilMahasiswa()
                }
            }
        })
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    private fun tampilMahasiswa() {
        listMahasiswa.layoutManager = LinearLayoutManager(activity)
        listMahasiswa.adapter = MahasiswaAdapter(
            requireActivity(),
            arrMahasiswa!! as ArrayList<Mahasiswa>
        )

    }


}