package ebj.habinyasuyujin.animefacts.utils.log

import timber.log.Timber

class LogTree: Timber.DebugTree() {

    companion object {
        private const val APP_NAME = "AnimeFacts"
    }

    override fun createStackElementTag(element: StackTraceElement): String {
        return with(element) {
            "$APP_NAME ($fileName:$lineNumber)@$methodName"
        }
    }
}