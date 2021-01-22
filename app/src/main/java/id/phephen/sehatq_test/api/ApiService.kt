package id.phephen.sehatq_test.api

import id.phephen.sehatq_test.response.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by phephen on 22,January,2021
 * https://github.com/fendysaputro
 */
interface ApiService {
    @GET("home")
    suspend fun getDataHome(): Response<BaseResponse>
}