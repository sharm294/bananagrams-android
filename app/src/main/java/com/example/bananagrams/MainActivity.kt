package com.example.bananagrams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import com.example.bananagrams.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
    }

    fun buttonClick(view : View){
        val txt: String = binding.charactersText.text.toString()

        val grid = binding.boardGrid
        grid.removeAllViews()

        for(i in 0 until 3) {
            val row = TableRow(grid.context)
            row.apply {
                layoutParams = TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
            }
//            row.layoutParams = TableRow.LayoutParams(
////                ViewGroup.LayoutParams.WRAP_CONTENT,
////                ViewGroup.LayoutParams.WRAP_CONTENT
//                TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT, 1f
//            )
            for (j in txt.indices) {
                val cell = Tile(row.context)
                val char = txt[j].toString()
                if(char == " "){
                    cell.myColor = R.color.white
                    cell.myShadow = false

                } else {
                    cell.myColor = R.color.tile
                }
                cell.apply {
                    layoutParams = TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                    )
                    myText = char
                }
                row.addView(cell)
            }
            grid.addView(row)
        }
    }

    /**
     * A native method that is implemented by the 'bananagrams' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'bananagrams' library on application startup.
        init {
            System.loadLibrary("bananagrams")
        }
    }
}