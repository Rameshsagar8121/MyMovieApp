package com.example.mydemoproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydemoproject.R
import com.example.mydemoproject.model.MovieModel
import com.squareup.picasso.Picasso

class MovieListAdapter (var context: Context,var movieModelList: MutableList<MovieModel>)
    :RecyclerView.Adapter<MovieListAdapter.Myviewmodel>(){
    inner class Myviewmodel(itemView: View):RecyclerView.ViewHolder(itemView){

        var imgMovie:ImageView
        var txtTittle:TextView
        var txtImbd:TextView
        var txttype:TextView
        var txtyear:TextView
        init {
            imgMovie=itemView.findViewById(R.id.imgMoviePoster)
            txtTittle=itemView.findViewById(R.id.MovieTitle)
            txtImbd=itemView.findViewById(R.id.txtImbid)
            txttype=itemView.findViewById(R.id.txtType)
            txtyear=itemView.findViewById(R.id.IdYear)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewmodel {
        return Myviewmodel(LayoutInflater.from(context).inflate(R.layout.layout_movie_list,parent,false))

    }
    override fun onBindViewHolder(holder: Myviewmodel, position: Int) {
        Picasso.get().load(movieModelList[position].poster).into(holder.imgMovie)
        holder.txtTittle.text =movieModelList[position].Title
        holder.txtImbd.text=movieModelList[position].imbdId
        holder.txttype.text=movieModelList[position].Type
        holder.txtyear.text=movieModelList[position].year
    }

    override fun getItemCount(): Int {
        return movieModelList.size
    }
}