package repos

import models.Post

interface PostRepository {
    suspend fun getPosts(cached: Boolean = false): List<Post>
}