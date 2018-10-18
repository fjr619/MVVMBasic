package x.fjr.mvvmbasic.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import x.fjr.mvvmbasic.MvvmApp
import x.fjr.mvvmbasic.ui.quotes.QuotesActivity
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            AppModule::class,
            QuotesActivityModules::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mvvmApp: MvvmApp)
}