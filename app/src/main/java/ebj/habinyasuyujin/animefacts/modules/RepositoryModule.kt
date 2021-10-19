package ebj.habinyasuyujin.animefacts.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ebj.habinyasuyujin.animefacts.api.AnimeFactsApi
import ebj.habinyasuyujin.animefacts.repository.AnimeFactsRepository
import ebj.habinyasuyujin.animefacts.repository.AnimeFactsRepositoryImpl
import ebj.habinyasuyujin.animefacts.repository.local.LocalRepository
import ebj.habinyasuyujin.animefacts.repository.local.LocalRepositoryImpl
import ebj.habinyasuyujin.animefacts.repository.local.room.AnimeFactsDatabase
import ebj.habinyasuyujin.animefacts.repository.remote.RemoteRepository
import ebj.habinyasuyujin.animefacts.repository.remote.RemoteRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAnimeFactsDatabase(@ApplicationContext context: Context): AnimeFactsDatabase {
        return AnimeFactsDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideLocalRepository(animeFactsDatabase: AnimeFactsDatabase): LocalRepository {
        return LocalRepositoryImpl(animeFactsDatabase)
    }

    @Singleton
    @Provides
    fun provideAnimeFactsApi(): AnimeFactsApi {
        return AnimeFactsApi.create()
    }

    @Singleton
    @Provides
    fun provideRemoteRepository(animeFactsApi: AnimeFactsApi): RemoteRepository {
        return RemoteRepositoryImpl(animeFactsApi)
    }

    @Singleton
    @Provides
    fun provideAnimeFactsRepository(localRepository: LocalRepository,
                                    remoteRepository: RemoteRepository
    ): AnimeFactsRepository {
        return AnimeFactsRepositoryImpl(localRepository, remoteRepository)
    }

}