package dk.nodes.template.injection.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dk.nodes.template.injection.DaggerViewModelFactory

@Module(
    includes = [
        ViewModelModule::class,
        ActivityBindingsModule::class
    ]
)
internal abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}