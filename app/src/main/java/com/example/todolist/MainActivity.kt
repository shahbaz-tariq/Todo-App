package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*import com.example.todolist.data.TodoDatabase
import com.example.todolist.data.TodoRepo
import com.example.todolist.model.Todo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch*/

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //Sample code to check if the DB working perfectly, IT DOES!
        /*val todoRepo = TodoRepo(TodoDatabase.getDatabase(this).todoDao())
        val newTodo = Todo(0, "Hello World", "Database Completed")

        GlobalScope.launch {
            todoRepo.insert(newTodo)

            todoRepo.getAllTodos()
        }*/

    }
}