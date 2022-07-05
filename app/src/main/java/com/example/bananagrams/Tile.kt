package com.example.bananagrams

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bananagrams.databinding.TileBinding

class Tile @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    private var binding: TileBinding

    var myText: String?
        get() = binding.textChar.text.toString()
        set(value){
            binding.textChar.text = value
        }

    var myColor: Int = 0xFFFFFF
        set(value){
//            binding.tile.setCardBackgroundColor(value)
            binding.tile.setBackgroundResource(value)
        }

    var myShadow: Boolean = true
        set(value){
            if(!value){
                binding.tile.elevation = 0f
            }
        }

    init{
//        binding = TileBinding.inflate(LayoutInflater.from(context), this)

        val foo = LayoutInflater.from(context).inflate(R.layout.tile, this, true)
        binding = TileBinding.bind(foo)

        attrs?.let {
//            val typedArray = context.obtainStyledAttributes(it,
//                R.styleable.Tile, 0, 0)
//            val title = resources.getText(typedArray
//                .getResourceId(R.styleable
//                    .Tile_my_text, R.string.app_name
//                ))

//            binding.textChar.text = "Q"
//            my_edit.hint =
//                "${resources.getString(R.string.hint_text)} $title"

//            typedArray.recycle()
        }
    }
}