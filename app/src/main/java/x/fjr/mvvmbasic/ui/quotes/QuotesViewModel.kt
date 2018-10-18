package x.fjr.mvvmbasic.ui.quotes

import androidx.lifecycle.ViewModel
import x.fjr.mvvmbasic.data.FakeQuoteDao
import x.fjr.mvvmbasic.data.Quote
import x.fjr.mvvmbasic.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}