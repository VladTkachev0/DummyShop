package com.example.retrofitloginlearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.retrofitloginlearn.R
import com.example.retrofitloginlearn.databinding.ActivityMainBinding
import com.example.retrofitloginlearn.view.login.LoginFragment
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), LoginFragment.OnFragmentInteractionListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar
        toolbar.title = ""
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawer, toolbar,   R.string.open, R.string.close)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onLoginSuccess(firstName: String, lastName: String, imageUrl: String) {
        val navView: NavigationView = binding.navView
        val headerView: View = navView.getHeaderView(0)

        val tvName: TextView = headerView.findViewById(R.id.tvName)
        val tvFname: TextView = headerView.findViewById(R.id.tvFname)
        val imageAvatar: ImageView = headerView.findViewById(R.id.imageAvatar)
        tvName.text = firstName
        tvFname.text = lastName
        Picasso.get().load(imageUrl).into(imageAvatar)
    }

}