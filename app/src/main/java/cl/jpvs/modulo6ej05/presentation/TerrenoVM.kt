package cl.jpvs.modulo6ej05.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.jpvs.modulo6ej05.data.Repositorio
import cl.jpvs.modulo6ej05.data.remote.Terreno
import cl.jpvs.modulo6ej05.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

val terrenosLiveData = MutableLiveData<List<Terreno>>()

    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        repositorio = Repositorio(api)
    }

    fun getAllTerrenos() = viewModelScope.launch {
        terrenosLiveData.value =repositorio.cargarTerreno()

    }

}