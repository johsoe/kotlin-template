package interactors

interface BaseAsyncInteractor<O> {
    suspend fun run(): O
}