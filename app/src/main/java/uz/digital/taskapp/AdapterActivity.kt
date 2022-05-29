package uz.digital.taskapp

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.digital.taskapp.databinding.ItemActivityBinding

class AdapterActivity : RecyclerView.Adapter<AdapterActivity.ViewHolder>() {

    var list = mutableSetOf<String>()

    fun updateList(list: MutableSet<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(text: String) {

            val activities = text.split("$")

            binding.checkboxTask.text = activities[0]
            binding.tvTime.text = activities[1]

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = ItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.elementAt(position))
    }
    override fun getItemCount(): Int {
        return list.size
    }

}