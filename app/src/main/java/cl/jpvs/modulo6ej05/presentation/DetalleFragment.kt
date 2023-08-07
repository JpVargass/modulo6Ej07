package cl.jpvs.modulo6ej05.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import cl.jpvs.modulo6ej05.databinding.FragmentDetalleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"

/**
 * A simple [Fragment] subclass.
 * Use the [DetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetalleFragment : Fragment() {
    private val terrenoVM: TerrenoVM by activityViewModels()
    lateinit var binding: FragmentDetalleBinding


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)
        terrenoVM.terrenosLiveData(param1.toString()).observe(viewLifecycleOwner){

        binding.tvIdDetalle.text = it.id
        binding.tvPrecioDetalle.text = it.precio.toString()
        binding.tvTipoDetalle.text = it.tipo
        binding.imageViewDetalle.load(it.img)
        }

        return binding.root
    }
}
