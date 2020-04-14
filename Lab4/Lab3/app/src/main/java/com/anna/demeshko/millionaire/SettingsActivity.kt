package com.anna.demeshko.millionaire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var preferencesHelper: PreferencesHelper
    private val list = listOf(5, 6, 7, 8, 9, 10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        preferencesHelper = PreferencesHelper(this)

        checkbox.isChecked = preferencesHelper.isHintEnabled
        checkbox.setOnCheckedChangeListener { _, isChecked ->
            preferencesHelper.isHintEnabled = isChecked
        }

        ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list).also {
            it.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = it
        }
        val index = list.indexOf(preferencesHelper.questionCount)
        spinner.setSelection(index)
        spinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        preferencesHelper.questionCount = list[position]
    }
}
