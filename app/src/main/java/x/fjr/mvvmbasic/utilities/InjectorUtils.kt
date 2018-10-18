package x.fjr.mvvmbasic.utilities

import x.fjr.mvvmbasic.data.FakeDatabase
import x.fjr.mvvmbasic.data.QuoteRepository
import x.fjr.mvvmbasic.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return  QuotesViewModelFactory(quoteRepository)
    }
}