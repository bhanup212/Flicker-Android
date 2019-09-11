package com.flickerandroid.bhanu.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.flickerandroid.bhanu.R
import com.flickerandroid.bhanu.model.Photo
import com.squareup.picasso.Picasso


class PhotoAdapter: RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    private var photoList = ArrayList<Photo>()

    override fun getItemCount(): Int {
        Log.e("Adapter","item size is:${photoList.size}")
      return photoList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PhotoHolder{
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.photo_row_item, parent, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photo = photoList[position]

        Picasso.get()
            .load(photo.size.size[0].url)
            .placeholder(R.drawable.ic_image_grey)
            .into(holder.imageView)

    }

    fun addPhotos(photos:ArrayList<Photo>){
        photoList.addAll(photos)
        notifyDataSetChanged()
    }


    inner class PhotoHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        val imageView:ImageView = itemView.findViewById(R.id.thumbnail)
    }


}