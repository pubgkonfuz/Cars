package com.example.cars.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cars.databinding.ItemCarsBinding
import com.example.cars.model.Car

class CarsAdapter(private val onItemClick: (car: Car) -> Unit) :
    ListAdapter<Car, CarsAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: ItemCarsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(getItem(adapterPosition))
            }
        }

        fun onBind(car: Car) {
            Glide.with(binding.ivItem).load(car.image)
                .into(binding.ivItem)
            binding.tvName.text = car.name
            binding.tvYear.text = car.year.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCarsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Car>() {

        override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem == newItem
        }
    }
}