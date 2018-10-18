package x.fjr.mvvmbasic.data

import javax.inject.Inject
import javax.inject.Singleton

//bisnis logic
@Singleton
class QuoteRepository @Inject constructor(private val quoteDao: FakeQuoteDao){

    //imagine a code which also updates and checks the backend
    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()
}