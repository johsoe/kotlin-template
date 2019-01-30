package dk.nodes.template.injection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dk.nodes.template.screens.main.MainActivity

@Module
internal abstract class ActivityBindingsModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

}