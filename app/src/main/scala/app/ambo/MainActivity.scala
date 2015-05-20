package app.ambo

import android.app.LoaderManager.LoaderCallbacks
import android.content.{AsyncTaskLoader, Loader}
import android.os.Bundle
import android.util.Log
import reactive.Observing
import reactive.android.app.ReactiveActivity

class MainActivity extends ReactiveActivity with Observing {
  for (e <- eCreate) {
    getLoaderManager.initLoader(1, null, new LoaderCallbacks[Unit] {
      def onLoaderReset(loader: Loader[Unit]) = {
        Log.i("TEST", "onLoaderReset")
      }

      def onLoadFinished(loader: Loader[Unit], data: Unit) = {
        Log.i("TEST", "onLoadFinished")
      }

      def onCreateLoader(id: Int, args: Bundle) = {
        Log.i("TEST", "onCreateLoader")
        new AsyncTaskLoader[Unit](MainActivity.this) {


          def loadInBackground() = {
            Log.i("TEST", "loadInBackground")
            ()
          }
        }
      }
    })
  }
}
