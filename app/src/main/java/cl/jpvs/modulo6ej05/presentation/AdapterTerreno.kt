package cl.jpvs.modulo6ej05.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.jpvs.modulo6ej05.data.local.TerrenoEntity
import cl.jpvs.modulo6ej05.data.remote.Terreno
import cl.jpvs.modulo6ej05.databinding.ItemTerrenoBinding
import coil.load
import coil.transform.CircleCropTransformation

class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>(){

    lateinit var binding: ItemTerrenoBinding
    private val listItemTerrenos = mutableListOf<TerrenoEntity>()


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
    fun setData(terreno : List<TerrenoEntity>){
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val binding: ItemTerrenoBinding): RecyclerView.ViewHolder(binding.root) {
     fun bind(terreno: TerrenoEntity) {
         binding.tvType.text = terreno.tipo
         binding.tvPrice.text = terreno.precio.toString()
         binding.imagenTerreno.load(terreno.imagen){
             crossfade(true)
             transformations(CircleCropTransformation())
         }
     }
    }


}