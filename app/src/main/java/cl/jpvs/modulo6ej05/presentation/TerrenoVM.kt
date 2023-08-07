package cl.jpvs.modulo6ej05.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.jpvs.modulo6ej05.data.Repositorio
import cl.jpvs.modulo6ej05.data.local.TerrenoDatabase
import cl.jpvs.modulo6ej05.data.remote.Terreno
import cl.jpvs.modulo6ej05.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio
    fun terrenosLiveData() = repositorio.obtenerTerrenos()
    init {
        val terrenoAPI = TerrenoRetroFit.getRetrofitTerreno()
        val terrenoBaseDatos = TerrenoDatabase.getDataBase(application).getITerrenoDao()
        repositorio = Repositorio(terrenoAPI, terrenoBaseDatos)
    }

    fun getAllTerrenos() = viewModelScope.launch {
        repositorio.cargarTerrenos()

    }
    fun terrenoLiveData(id: String) = repositorio.obtenerTerrenos()

}