package cl.jpvs.modulo6ej05.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.jpvs.modulo6ej05.R
import cl.jpvs.modulo6ej05.data.local.TerrenoEntity
import cl.jpvs.modulo6ej05.data.remote.Terreno
import cl.jpvs.modulo6ej05.databinding.ItemTerrenoBinding
import coil.load
import coil.transform.CircleCropTransformation

class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    private val listItemTerrenos = mutableListOf<TerrenoEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemTerrenoViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return listItemTerrenos.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listItemTerrenos[position]
        holder.bind(terreno)
    }

    fun setData(terreno: List<TerrenoEntity>) {
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v: ItemTerrenoBinding) : RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: TerrenoEntity) {
           // v.tvType.text = terreno.tipo
           // v.tvPrice.text = terreno.precio.toString()
            v.imagenTerreno.load(terreno.imagen) {
                crossfade(true)
                transformations(CircleCropTransformation())
                v.cvItem.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putString("id", terreno.id)
                    //bundle.putInt("precio", terreno.precio)
                    //bundle.putString("tipo", terreno.tipo)
                    //bundle.putString("img", terreno.imagen)
                    Navigation.findNavController(v.root)
                        .navigate(R.id.action_listadoTerrenos_to_detalleFragment, bundle)
                }


            }
        }
    }


}