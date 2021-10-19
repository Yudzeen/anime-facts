package ebj.habinyasuyujin.animefacts.utils.lifecycle

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * A utility base class for view models which perform rxjava operations
 */
abstract class RxViewModel: ViewModel() {

    private val disposables = CompositeDisposable()

    fun Disposable.bind() {
        disposables.add(this)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}