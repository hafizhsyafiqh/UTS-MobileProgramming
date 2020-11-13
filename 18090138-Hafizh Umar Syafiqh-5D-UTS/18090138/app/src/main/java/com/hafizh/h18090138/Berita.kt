package com.hafizh.h18090138


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_berita.*

class Berita : AppCompatActivity() {

    val list = ArrayList<Users>()

    val listUsers = arrayOf(
        "Gatot Terima Tanda Jasa Dari Jokowi Meski Tak Hadir Di Istana",
        "DPR Minta Pemerintah Efektifkan Bansos Cegah Resesi Akibar Covid-19",
        "KSP: Apakah Ada UU Ciptaker yang Diperbaiki? Tidak Ada"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)

        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        for (i in 0 until listUsers.size){

            list.add(Users(listUsers.get(i)))

            if(listUsers.size - 1 == i){
                // init adapter yang telah dibuat tadi
                val adapter = Adapter(list)
                adapter.notifyDataSetChanged()

                //tampilkan data dalam recycler view
                mRecyclerView.adapter = adapter
            }

        }

    }


}
