package com.aldoapp.noteapp

import android.content.AbstractThreadedSyncAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldoapp.noteapp.adapter.NoteAdapter
import com.aldoapp.noteapp.model.NoteModel
import kotlinx.android.synthetic.main.activity_homepage.*

class Homepage : AppCompatActivity() {

    lateinit var adapternote: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        add_img.setOnClickListener { v ->
            startActivity(Intent(this@Homepage, InputNote::class.java))

            }
        setAdapter()

        }
    private fun setAdapter() {

        adapternote = NoteAdapter()
        adapternote.addAll(listDataNote())
        recycler.apply {

            layoutManager = LinearLayoutManager( this@Homepage)
            setHasFixedSize(true)
            adapter = adapternote

        }
    }

    private fun listDataNote(): List<NoteModel> {
        return listOf(

            NoteModel(
                1,
                "Makanan",
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.\n"
            ),
            NoteModel(
                1,
                "Minuman",
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.\n"
            ),
            NoteModel(
                1,
                "Snack",
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.\n"
            ),
            NoteModel(
                1,
                "Aksesoris",
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.\n"
            )
        )
    }
}

