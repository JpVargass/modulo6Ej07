package cl.jpvs.modulo6ej05.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface TerrenoAPI {
    @GET("realestate")
    suspend fun getData(): Response<List<Terreno>>

}