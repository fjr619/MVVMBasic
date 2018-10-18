package x.fjr.mvvmbasic.ui.quotes

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_quotes.*
import x.fjr.mvvmbasic.MvvmApp
import x.fjr.mvvmbasic.R
import x.fjr.mvvmbasic.data.Quote
import x.fjr.mvvmbasic.di.AppInjector
import x.fjr.mvvmbasic.di.Injectable
import java.lang.StringBuilder
import javax.inject.Inject

class QuotesActivity : AppCompatActivity(), Injectable, HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val quotesViewModel: QuotesViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(QuotesViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        AndroidInjection.inject(this)
        initializeUI()
    }

    private fun initializeUI() {
        quotesViewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach {
                quote -> stringBuilder.append("$quote\n\n")
            }

            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            v ->
                val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            quotesViewModel.addQuote(quote)
                editText_author.setText("")
                editText_quote.setText("")


        }

    }
}
