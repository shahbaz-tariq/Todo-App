package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.model.Todo

class TodoAdapter : ListAdapter<Todo, TodoAdapter.TodoViewHolder>(TodoComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    fun getTodo(position: Int): Todo {
        return getItem(position)
    }

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.tvTitle)
        private val desc: TextView = itemView.findViewById(R.id.tvDesc)

        fun bind(todo: Todo) {
            title.text = todo.name
            desc.text = todo.desc
        }

        companion object {
            fun create(parent: ViewGroup): TodoViewHolder {
                val view: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.each_rv, parent, false)
                return TodoViewHolder(view)
            }
        }
    }

    class TodoComparator : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
