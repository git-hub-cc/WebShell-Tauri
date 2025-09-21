package club.ppmc.claims

import android.os.Bundle
// ✅ MODIFICATION START: Import necessary classes for modern Window Insets handling
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
// ✅ MODIFICATION END

class MainActivity : TauriActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // ✅ MODIFICATION START: Implement the robust WindowInsets listener solution.

    // Stage 1: Enable Edge-to-Edge display.
    // This tells the system that our app will handle drawing behind the system bars (status bar, navigation bar).
    // It's a prerequisite for manually controlling layout based on insets.
    WindowCompat.setDecorFitsSystemWindows(window, false)

    // Get the root content view of the activity. This is the view that holds our WebView.
    val contentView = findViewById<android.view.View>(android.R.id.content)

    // Stage 2 & 3: Attach a listener that fires whenever window insets change.
    // This is triggered by system bars appearing/disappearing and, crucially, by the keyboard (IME) showing/hiding.
    ViewCompat.setOnApplyWindowInsetsListener(contentView) { view, windowInsets ->
      // Get the insets (padding) caused by system bars (status bar, navigation bar).
      val systemBars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
      // Get the insets caused by the keyboard (Input Method Editor).
      val ime = windowInsets.getInsets(WindowInsetsCompat.Type.ime())

      // Calculate the final bottom padding. We need to leave space for whichever is taller:
      // the navigation bar (from systemBars.bottom) or the keyboard (from ime.bottom).
      val bottomPadding = Math.max(systemBars.bottom, ime.bottom)

      // Apply the calculated insets as padding to our content view.
      // This effectively pushes our WebView content into the safe, visible area,
      // dynamically adjusting when the keyboard appears or disappears.
      view.setPadding(
        systemBars.left,
        systemBars.top,
        systemBars.right,
        bottomPadding
      )

      // Return the original insets. This is standard practice to allow the system
      // to continue dispatching these insets to any child views if needed.
      windowInsets
    }
    // ✅ MODIFICATION END
  }
}