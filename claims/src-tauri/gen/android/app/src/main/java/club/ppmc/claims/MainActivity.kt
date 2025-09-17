package club.ppmc.claims

import android.os.Bundle
// ✅ MODIFICATION START: Import necessary classes for handling Window Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// ✅ MODIFICATION END

class MainActivity : TauriActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // ✅ MODIFICATION START: Implement the definitive solution using an Insets listener.
    // This approach is more robust than setting window flags, as it defines a permanent rule
    // for how the main content view should react to system bars like the status bar.

    // 1. Get the root content view of the activity. This is the view that holds our WebView.
    val contentView = findViewById<android.view.View>(android.R.id.content)

    // 2. Attach a listener that fires whenever the window insets (areas occupied by system bars) change.
    ViewCompat.setOnApplyWindowInsetsListener(contentView) { view, windowInsets ->

      // 3. Get the insets specifically for the system bars (status bar and navigation bar).
      val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

      // 4. Apply these insets as padding to our content view.
      //    - view.setPadding(left, top, right, bottom)
      //    This command forces our content (the WebView) to be laid out *inside* the space
      //    defined by the system bars, effectively pushing it below the status bar.
      view.setPadding(insets.left, insets.top, insets.right, insets.bottom)

      // 5. Return the insets to allow the system to continue processing them for child views.
      WindowInsetsCompat.CONSUMED
    }
    // ✅ MODIFICATION END
  }

  // ❌ DEPRECATED: The onWindowFocusChanged override is no longer the primary strategy,
  // as the Insets listener is more reliable. You can safely remove the previous override
  // of this method if you had it.
}