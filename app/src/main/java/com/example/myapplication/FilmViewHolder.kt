package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FilmItemBinding

class FilmViewHolder(val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {
    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {
        //Устанавливаем заголовок
        binding.title.text = film.title
        //Устанавливаем постер
        binding.poster.setImageResource(film.poster)
        //Устанавливаем описание
        binding.description.text = film.description
    }
}