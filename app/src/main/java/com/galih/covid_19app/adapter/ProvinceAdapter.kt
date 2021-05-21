package com.galih.covid_19app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.galih.covid_19app.databinding.AdapterProvinceBinding
import com.galih.covid_19app.model.ProvinceResponse

class ProvinceAdapter(private var list: ArrayList<ProvinceResponse>): RecyclerView.Adapter<ProvinceAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterProvinceBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val province = list[position]

        holder.binding.tvName.text = province.attributes.province
        holder.binding.tvPositive.text = province.attributes.positive.toString()
        holder.binding.tvRecover.text = province.attributes.recover.toString()
        holder.binding.tvDeath.text = province.attributes.death.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(val binding: AdapterProvinceBinding): RecyclerView.ViewHolder(binding.root)
}