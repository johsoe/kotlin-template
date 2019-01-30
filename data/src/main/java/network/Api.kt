package network

import io.reactivex.Single
import models.Photo
import models.Post
import okio.BufferedSource
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("photos")
    fun getPhotos(): Call<List<Photo>>

    @GET("posts")
    fun getPostsBuffered(): Single<BufferedSource>
}
