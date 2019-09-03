package com.training.app.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.pixplicity.easyprefs.library.Prefs
import com.training.app.R
import com.training.app.recyclerview.RecyclerViewExampleScreen
import kotlinx.android.synthetic.main.fragment_test.*

/**
 * https://developer.android.com/guide/navigation/navigation-getting-started
 * https://medium.com/google-developer-experts/android-navigation-components-part-3-19554ec9ae83
 */

class TestFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test, container , false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navButton.setOnClickListener {
            findNavController().navigate(R.id.action_testFragment_to_test2Fragment)
        }

        showRecyclerView.setOnClickListener {
//            startActivity(Intent(activity!! , RecyclerViewExampleScreen::class.java))
            findNavController().navigate(R.id.action_testFragment_to_mathFragment)
        }

        button.setOnClickListener {
            Prefs.putString("UserStatus" , EditText1.getText().toString())
        }

        ShowPref.setOnClickListener {
            Toast.makeText(activity!! , Prefs.getString("UserStatus" , "") , Toast.LENGTH_SHORT).show()
        }
    }

}
