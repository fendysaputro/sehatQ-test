package id.phephen.sehatq_test.response

import java.io.Serializable

/**
 * Created by phephen on 22,January,2021
 * https://github.com/fendysaputro
 */
data class ProductPromo(
    val description: String,
    val id: String,
    val imageUrl: String,
    val loved: Int,
    val price: String,
    val title: String
) : Serializable
