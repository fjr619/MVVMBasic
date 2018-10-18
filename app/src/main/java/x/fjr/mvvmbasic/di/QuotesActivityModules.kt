package x.fjr.mvvmbasic.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import x.fjr.mvvmbasic.ui.quotes.QuotesActivity

@Suppress("unused")
@Module
abstract class QuotesActivityModules {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeQuotesActivity(): QuotesActivity

}
