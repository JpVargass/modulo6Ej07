package cl.jpvs.modulo6ej05.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.jpvs.modulo6ej05.R
import cl.jpvs.modulo6ej05.data.remote.Terreno
import cl.jpvs.modulo6ej05.databinding.FragmentListadoTerrenosBinding
import cl.jpvs.modulo6ej05.databinding.ItemTerrenoBinding
import coil.load
import coil.transform.CircleCropTransformation

class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>(){

    lateinit var binding: ItemTerrenoBinding
    private val listItemTerrenos = mutableListOf<Terreno>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent,false)

        return ItemTerrenoViewHolder(binding)

    }

    override fun getItemCount(): Int {
     return listItemTerrenos.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listItemTerrenos[position]
        holder.bind(terreno)
    }
    fun setData(terreno : List<Terreno>){
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v: ItemTerrenoBinding): RecyclerView.ViewHolder(v.root) {
     fun bind(terreno : Terreno) {
         v.tvType.text = terreno.tipo
         v.tvPrice.text = terreno.precio.toString()
         v.imagenTerreno.load(terreno.img){
             crossfade(true)
             transformations(CircleCropTransformation())
         }
     }
    }

}