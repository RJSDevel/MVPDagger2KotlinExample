package pro.yagupov.model

import android.content.Context
import dagger.Module
import dagger.Provides
import pro.yagupov.model.repository.Repository
import pro.yagupov.model.repository.RepositoryImpl

/**
 * Created by developer on 01.06.17.
 */
@Module
class RepositoryModule(context : Context) {

    @Provides
    fun provideRepository() : Repository = RepositoryImpl()
}