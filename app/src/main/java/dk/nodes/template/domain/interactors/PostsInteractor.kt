package dk.nodes.template.domain.interactors

import dk.nodes.template.domain.models.Post
import dk.nodes.template.domain.models.Result
import dk.nodes.template.domain.repositories.PostRepository
import dk.nodes.template.domain.repositories.RepositoryException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PostsInteractor @Inject constructor(
    private val postRepository: PostRepository
): BaseAsyncInteractor<Result<List<Post>>> {

    override suspend fun run(): Result<List<Post>> {
        return try {
            val posts = postRepository.getPosts(true)
            Result.Success(posts)
        } catch (e: RepositoryException) {
            Result.Error(e)
        }
    }
}