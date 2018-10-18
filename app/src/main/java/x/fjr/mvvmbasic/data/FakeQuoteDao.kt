package x.fjr.mvvmbasic.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import x.fjr.mvvmbasic.data.Quote

class FakeQuoteDao() {
    //fake database table
    private val quoteList = mutableListOf<Quote>()

    //livedata can be observed for changes
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList

    }

//    fun getQuotes() : LiveData<List<Quote>> {
//       return quotes
//    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}