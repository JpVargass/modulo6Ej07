package cl.jpvs.modulo6ej05.data


import cl.jpvs.modulo6ej05.data.remote.Terreno
import cl.jpvs.modulo6ej05.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI) {


    suspend fun cargarTerreno(): List<Terreno> {
          val respuesta =terrenoAPI.getData()
        if (respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let {
                return it
            }
        }
        return emptyList()
    }

}