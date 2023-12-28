package com.ramesh.baseproject.ui.base

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import android.os.*
import android.view.Menu
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import com.ramesh.baseproject.R
import com.ramesh.baseproject.ui.main.MainActivity

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    //lateinit var viewModel: VM
    protected abstract val viewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObservers()
        setupView(savedInstanceState)
        viewModel.onCreate()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }


    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    protected fun showSettingsDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Need Permissions")
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.")
        builder.setPositiveButton("GOTO SETTINGS", DialogInterface.OnClickListener { dialog, _ ->
            dialog.cancel()
            openSettings()
        })
        builder.setNegativeButton(
            "Cancel",
            DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() })
        builder.show()
    }

    // navigating user to app settings
    private fun openSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri: Uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        resultLauncher.launch(intent)

    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { _ ->

        }

    fun showMessage(message: String) =
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    fun hideKeyboard(view: View) {
        val inputMethodManager =
            view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    open fun goBack() = onBackPressedCallback

    private val onBackPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (supportFragmentManager.backStackEntryCount > 0) supportFragmentManager.popBackStackImmediate()
                else onBackPressedDispatcher.onBackPressed()
            }
        }

    protected abstract fun provideLayoutId(): View

    protected abstract fun setupView(savedInstanceState: Bundle?)

    val updateHandler = Handler(Looper.getMainLooper())

    val runnable = Runnable {
        updateDisplay() // some action(s)
    }

    private fun updateDisplay() {
        navigate()
    }

    private fun navigate() {
        startActivity(Intent(this, MainActivity::class.java))
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        updateHandler.removeCallbacks(runnable)
        super.onStop()
    }

}