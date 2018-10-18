package x.fjr.mvvmbasic.data

//bisnis logic
class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    companion object { //singleton klo ada passing constructor, normal object tidak bisa punya constructor
        @Volatile private  var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) = instance ?: synchronized(this) {
            instance ?: QuoteRepository (quoteDao).also { instance = it }
        }
    }

    //imagine a code which also updates and checks the backend
    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()
}