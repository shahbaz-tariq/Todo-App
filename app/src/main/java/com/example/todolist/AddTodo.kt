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

        when (intent.getStringExtra("type")) {
            "update" -> {
                title = "Update Todo"
                binding.etTitle.setText(intent.getStringExtra("name"))
                binding.etDesc.setText(intent.getStringExtra("desc"))
                val id: Int = intent.getIntExtra("id", 0)
                binding.add.text = "Update"
                binding.add.setOnClickListener {
                    val replyIntent = Intent()
                    if (TextUtils.isEmpty(binding.etTitle.text)) {
                        setResult(0, replyIntent)
                    } else {
                        val title = binding.etTitle.text.toString()
                        val desc = binding.etDesc.text.toString()
                        replyIntent.putExtra(EXTRA_REPLY, title)
                        replyIntent.putExtra(EXTRA_REPLY2, desc)
                        setResult(2, replyIntent)
                        intent.putExtra("id", id)
                    }
                    finish()
                }
            }

            else -> {
                title = "Add Todo"
                binding.add.setOnClickListener {
                    val replyIntent = Intent()
                    if (TextUtils.isEmpty(binding.etTitle.text)) {
                        setResult(0, replyIntent)
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
        }

    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.todolistsql.REPLY"
        const val EXTRA_REPLY2 = "com.example.android.todolistsql.REPLY2"
    }
}
