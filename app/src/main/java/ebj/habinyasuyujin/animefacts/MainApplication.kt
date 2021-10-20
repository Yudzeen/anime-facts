package ebj.habinyasuyujin.animefacts

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ebj.habinyasuyujin.animefacts.utils.log.LogTree
import timber.log.Timber

@HiltAndroidApp
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(LogTree())
    }

}