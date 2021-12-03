package ru.skillbranch.learningproject.presentation.adapter

import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.learningproject.databinding.ItemAnimeMangaBinding
import ru.skillbranch.learningproject.model.Movie
import java.net.URL

class AnimeMangaAdapter : PagingDataAdapter<Movie, AnimeMangaAdapter.AnimeMangaHolder>(
    object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean =
            oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeMangaHolder =
        AnimeMangaHolder(
            ItemAnimeMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AnimeMangaHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AnimeMangaHolder(
        private val binding: ItemAnimeMangaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movie?) {
            with(binding) {
                tvTitle.text = item?.title
                tvEpisodesChapters.text = "${item?.episodes} episodes in total"
            }
        }
    }
}
