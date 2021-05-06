package com.example.factsapp.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.example.factsapp.screens.DetailActivity
import com.example.factsapp.model.FactsModel
import com.example.factsapp.R

class FactsAdapter(
       context: Context,
       facts: List<FactsModel>
          ):ArrayAdapter<FactsModel>(context,0,facts) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val fact = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.facts_layout,parent,false)
    }
        val logo = view?.findViewById<ImageView>(R.id.imageLogo)
        val name = view?.findViewById<TextView>(R.id.nameTv)


        if (fact != null) {
            logo?.setImageResource(fact.logoResourceId)
        }

        if (fact != null) {
            name?.text = context.resources.getString(fact.nameResourceId)
        }

        view?.setOnClickListener {
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRA, fact?.logoResourceId)
            intent.putExtra(NAME_EXTRA, context.resources.getString(fact!!.nameResourceId))
            intent.putExtra(FACT_EXTRA, context.resources.getString(fact.factsResourceId))
            parent.context.startActivity(intent)

        }
        return view!!
    }

    companion object {//keys to pass intent values
        const val LOGO_EXTRA = "logo_extras"
        const val NAME_EXTRA = "name_extras"
        const val FACT_EXTRA = "fact_extras"
    }
}