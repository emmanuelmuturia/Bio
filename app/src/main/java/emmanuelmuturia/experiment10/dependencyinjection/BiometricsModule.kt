package emmanuelmuturia.experiment10.dependencyinjection

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import emmanuelmuturia.experiment10.uilayer.homescreen.BiometricsViewModel
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BiometricsModule {

    @Provides
    @Singleton
    fun providesBiometricsViewModel(application: Application): BiometricsViewModel {
        return BiometricsViewModel(application = application)
    }

}