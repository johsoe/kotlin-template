package repos

import misc.RepositoryException
import models.Post
import network.Api


class RestPostRepository(private val api: Api) : PostRepository {
    @Throws(RepositoryException::class)
    override suspend fun getPosts(cached: Boolean): List<Post> {
        val response = api.getPosts().execute()
        if (response.isSuccessful) {
            return response.body() ?: throw(RepositoryException(response.code(), response.message()))
        }
        throw(RepositoryException(response.code(), response.message()))
    }
}