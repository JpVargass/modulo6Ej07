package cl.jpvs.modulo6ej05.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
class TerrenoDao {

    @Insert
    suspend fun insertTerreno (terrenoEntity: TerrenoEntity )

    @Query("select * from tabla_terreno order by id ASC" )
 fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>
}