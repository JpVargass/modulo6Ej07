package cl.jpvs.modulo6ej05.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tabla_terreno")
data class TerrenoEntity(
 @PrimaryKey val id: String,
 val precio: Int,
 val tipo: String,
 val imagen: String
)
