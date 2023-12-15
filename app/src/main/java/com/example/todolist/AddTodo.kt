package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.todolist.databinding.ActivityAddTodoBinding

class AddTodo : AppCompatActivity() {
    lateinit var binding: ActivityAddTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val title = binding.etTitle
        val desc = binding.etDesc
        val btn = binding.add*/

        binding.add.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(binding.etTitle.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val title = binding.etTitle.text.toString()
                val desc = binding.etDesc.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, title)
                replyIntent.putExtra(EXTRA_REPLY2, desc)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.todolistsql.REPLY"
        const val EXTRA_REPLY2 = "com.example.android.todolistsql.REPLY2"
    }
}
