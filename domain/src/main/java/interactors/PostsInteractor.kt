package interactors

import misc.RepositoryException
import models.Post
import repos.PostRepository
import javax.inject.Inject

class PostsInteractor @Inject constructor(
    private val postRepository: PostRepository
): BaseAsyncInteractor<PostsInteractor.Result> {

    sealed class Result {
        data class Success(val list: List<Post>): Result()
        data class Failure(val e: RepositoryException): Result()
    }

    override suspend fun run(): PostsInteractor.Result {
        return try {
            val posts = postRepository.getPosts(true)
            Result.Success(posts)
        } catch (e: RepositoryException) {
            Result.Failure(e)
        }
    }
}