package x.fjr.mvvmbasic

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import x.fjr.mvvmbasic.BuildConfig
import x.fjr.mvvmbasic.di.AppInjector
import javax.inject.Inject

class MvvmApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //setup timber
        }

        AppInjector.init(this)
    }
}