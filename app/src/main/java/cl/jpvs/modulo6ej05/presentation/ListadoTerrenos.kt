package cl.jpvs.modulo6ej05.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.jpvs.modulo6ej05.databinding.FragmentListadoTerrenosBinding


class ListadoTerrenos : Fragment() {
    lateinit var binding: FragmentListadoTerrenosBinding
    private val terrenoVM: TerrenoVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoTerrenosBinding.inflate(layoutInflater, container, false)
        initAdapter()

        return binding.root
    }
private fun initAdapter() {
    // a continuacion se le indica al ViewModel que obtenga la informacion
    terrenoVM.getAllTerrenos()
    val adapter = AdapterTerreno()
    binding.recyclerTerreno.adapter = adapter
    //a continuaciòn se observa cuando llega la informaciòn y se muestra a travez del LiveData
    terrenoVM.terrenosLiveData().observe(viewLifecycleOwner){
        adapter.setData(it)
    }

}

}
