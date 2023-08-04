package cl.jpvs.modulo6ej05.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TerrenoDao {

    @Insert
    suspend fun insertarTerreno (terrenoEntity: TerrenoEntity )

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTerrenos(terrenoEntity: List<TerrenoEntity>)

    @Query("select * from tabla_terreno order by id ASC" )
 fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>
}