package com.example.weatherapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.repository.Repository
import com.example.weatherapplication.utils.Constants.Companion.API_KEY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var image_path: String = ""
    private var resId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getWeather("Kiev", API_KEY)
        viewModel.myResponse2.observe(this, Observer { response2 ->
            if (response2.isSuccessful) {
                temp_id.text = (response2.body()?.main?.temp.toString() + "℃");
                city_id.text = response2.body()?.name.toString();

                image_path = "i";
                image_path += response2.body()?.weather?.get(0)?.icon.toString()

                resId = this.resources.getIdentifier(image_path, "drawable", this.packageName);
                image_id.setImageResource(resId)
            } else {
                temp_id.text = "Error town!"
                city_id.text = response2.code().toString();
            }
        })

        search_image_id.setOnClickListener {
            hideKeyboard()
            val helptekst = search_text_id.text
            if (helptekst.isNotEmpty()) {
                viewModel.getWeather(helptekst.toString(), API_KEY);
            } else {
                Toast.makeText(this@MainActivity, "Please enter your town!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun MainActivity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}