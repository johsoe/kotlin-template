package dk.nodes.template.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dk.nodes.template.base.BaseViewModel
import dk.nodes.template.nstack.Translation
import dk.nodes.template.util.Event
import interactors.PostsInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
        private val postsInteractor: PostsInteractor
) : BaseViewModel() {

    private val _viewState = MutableLiveData<MainActivityViewState>()
    val viewState: LiveData<MainActivityViewState> = _viewState

    fun fetchPosts() = scope.launch {
        _viewState.value = MainActivityViewState(isLoading = true)
        val result = withContext(Dispatchers.IO) { postsInteractor.run() }
        when(result) {
            is PostsInteractor.Result.Success -> _viewState.value = _viewState.value?.copy(
                    isLoading = false,
                    posts = result.list
            )
            is PostsInteractor.Result.Failure -> _viewState.value = _viewState.value?.copy(
                    isLoading = false,
                    errorMessage = Event(Translation.error.unknownError)
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}