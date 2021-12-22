package com.wahyuindra.uap

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.mahasiswa_item.*

class MahasiswaAdapter (private val context: Context, private val items: ArrayList<Mahasiswa>) :
    RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.mahasiswa_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(item: Mahasiswa) {
            txtNIM.text = "NIM : " + item.nim
            txtNama.text = "Nama : " + item.nama
            txtProdi.text = "Prodi : " + item.prodi
            txtAlamat.text = "Alamat : " + item.alamat
        }
    }

}