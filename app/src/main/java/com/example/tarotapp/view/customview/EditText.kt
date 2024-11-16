package com.example.tarotapp.view.customview

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tarotapp.R
import com.example.tarotapp.databinding.EdittextWithTitleBinding
import com.google.android.material.textfield.TextInputLayout

class EditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private val binding =
        EdittextWithTitleBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.EditText, defStyle, 0)
        val title = typedArray.getString(R.styleable.EditText_title)
        val hint = typedArray.getString(R.styleable.EditText_hint)
        val type = typedArray.getInt(R.styleable.EditText_type, 0)

        setTitle(title)
        setHint(hint)
        setType(type)
    }

    fun setTitle(text: String?) {
        binding.title.text = text
        binding.title.visibility = if (text == null) {
            GONE
        } else {
            VISIBLE
        }
    }

    fun setHint(text: String?) {
        binding.editText.hint = text
    }

    fun setType(type: Int) {
        when(type) {
            Type.PASSWORD.id -> {
                binding.inputLayout.endIconMode = TextInputLayout.END_ICON_PASSWORD_TOGGLE
                binding.editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            Type.PHONE.id -> {
                binding.inputLayout.endIconMode = TextInputLayout.END_ICON_NONE
                binding.editText.inputType = InputType.TYPE_CLASS_PHONE
            }
            else -> {
                binding.inputLayout.endIconMode = TextInputLayout.END_ICON_NONE
                binding.editText.inputType = InputType.TYPE_CLASS_TEXT
            }
        }
    }

    enum class Type(val id: Int) {
        TEXT(0), PASSWORD(1), PHONE(2)
    }
}