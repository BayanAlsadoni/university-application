package com.example.finalapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.finalapplication.R
import com.example.finalapplication.classes.Universty

class ListAdapter(var context: Context, var data:ArrayList<Universty>): BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var adapterView= convertView
        if(convertView==null)
            adapterView= LayoutInflater.from(context).inflate(R.layout.universty_item,parent,false)
        var img= adapterView!!.findViewById<ImageView>(R.id.img)
        var tv= adapterView.findViewById<TextView>(R.id.tv)
        val univ= data[position]
        img.setImageResource(univ.img)
        tv.text= univ.name
        return adapterView
    }
}

