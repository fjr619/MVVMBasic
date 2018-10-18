package x.fjr.mvvmbasic.di

import dagger.Module
import dagger.Provides
import x.fjr.mvvmbasic.data.FakeDatabase
import x.fjr.mvvmbasic.data.FakeQuoteDao
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideFakeQuoteDao(): FakeQuoteDao {
        return FakeDatabase.getInstance().quoteDao
    }
}