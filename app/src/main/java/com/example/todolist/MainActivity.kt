package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.Todo

/*import com.example.todolist.data.TodoDatabase
import com.example.todolist.data.TodoRepo
import com.example.todolist.model.Todo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch*/

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = TodoAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        todoViewModel.allTodos.observe(this, Observer { todo ->
            todo?.let { adapter.submitList(it) }
        })


        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddTodo::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }

        //Sample code to check if the DB working perfectly, IT DOES!
        /*val todoRepo = TodoRepo(TodoDatabase.getDatabase(this).todoDao())
        val newTodo = Todo(0, "Hello World", "Database Completed")

        GlobalScope.launch {
            todoRepo.insert(newTodo)

            todoRepo.getAllTodos()
        }*/

    }

    private val todoViewModel: TodoViewModel by viewModels {
        TodoViewModel.TodoViewModelFactory((application as TodoApplication).repository)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            val reply1 = data?.getStringExtra(AddTodo.EXTRA_REPLY)
            val reply2 = data?.getStringExtra(AddTodo.EXTRA_REPLY2)

            if (reply1 != null && reply2 != null) {
                val todo = Todo(0,reply1, reply2)
                todoViewModel.insert(todo)
            } else {
                Toast.makeText(
                    applicationContext,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG
                ).show()
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }

    }

}