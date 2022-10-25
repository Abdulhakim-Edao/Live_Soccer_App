package com.example.fragments.ui.fixtures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.fragments.R

import kotlinx.android.synthetic.main.activity_fixtures.*
import java.util.*
import kotlin.collections.ArrayList

class FixturesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fixtures)
        datesRCV.adapter = FixtureDateAdapter(this, 28)

    }

}