package x.fjr.mvvmbasic.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import x.fjr.mvvmbasic.ViewModelFactory
import x.fjr.mvvmbasic.ui.quotes.QuotesViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuotesViewModel::class)
    abstract fun bindQuotesViewModel(quotesViewModel: QuotesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}