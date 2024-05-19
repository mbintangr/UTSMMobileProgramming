package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AlumniAdapter(private val context: Context, private val dataSource: List<Alumni>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_alumni, parent, false)
            holder = ViewHolder()
            holder.nimTextView = view.findViewById(R.id.nimTextView) as TextView
            holder.namaTextView = view.findViewById(R.id.namaTextView) as TextView
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val alumni = getItem(position) as Alumni
        holder.nimTextView.text = "NIM: " + alumni.nim
        holder.namaTextView.text = "Nama: " + alumni.nama

        return view
    }

    private class ViewHolder {
        lateinit var nimTextView: TextView
        lateinit var namaTextView: TextView
    }
}
