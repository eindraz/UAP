package com.wahyuindra.uap

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Mahasiswa(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val nim : String,
    val nama : String,
    val prodi : String,
    val alamat : String,
)
