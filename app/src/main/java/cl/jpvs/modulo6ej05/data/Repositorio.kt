package cl.jpvs.modulo6ej05.data


import androidx.lifecycle.LiveData
import cl.jpvs.modulo6ej05.data.local.TerrenoDao
import cl.jpvs.modulo6ej05.data.local.TerrenoEntity
import cl.jpvs.modulo6ej05.data.remote.Terreno
import cl.jpvs.modulo6ej05.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI, private val  terrenoDao: TerrenoDao) {
fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos()


    suspend fun cargarTerreno() {
          val respuesta =terrenoAPI.getData()
        if (respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let {

            }
        }

    }

}