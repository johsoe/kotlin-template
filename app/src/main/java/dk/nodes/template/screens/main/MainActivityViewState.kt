package dk.nodes.template.screens.main

import dk.nodes.template.util.Event
import models.Post

data class MainActivityViewState(
        val posts: List<Post> = emptyList(),
        val errorMessage: Event<String>? = null,
        val isLoading: Boolean = false
)