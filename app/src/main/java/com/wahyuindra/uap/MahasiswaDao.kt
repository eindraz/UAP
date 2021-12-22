package com.wahyuindra.uap

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MahasiswaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahMahasiswa(mahasiswa: Mahasiswa)

    @Query("SELECT * FROM Mahasiswa")
    fun ambilSemuaMahasiswa(): LiveData<List<Mahasiswa>>

}