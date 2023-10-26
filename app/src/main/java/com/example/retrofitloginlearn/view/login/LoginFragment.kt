package com.example.retrofitloginlearn.view.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.retrofitloginlearn.R
import com.example.retrofitloginlearn.databinding.FragmentLoginBinding
import com.example.retrofitloginlearn.model.AuthRequest
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding
    private val binding get() = _binding!!

    private var listener: OnFragmentInteractionListener? = null

    private val loginViewModel: LoginViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginViewModel.error.observe(viewLifecycleOwner, Observer { errorMsg ->
            Toast.makeText(requireContext(), errorMsg, Toast.LENGTH_SHORT).show()
        })
        binding.btnLogin.setOnClickListener {
            val user = AuthRequest(binding.edLogin.text.toString(), binding.edPassword.text.toString())
            loginViewModel.getUser(user)
            loginViewModel.userList.observe(viewLifecycleOwner, { list ->
                findNavController().navigate(R.id.action_loginFragment_to_listFragment)
                listener?.onLoginSuccess(list.firstName, list.lastName, list.image)
            })
        }

    }
    interface OnFragmentInteractionListener {
        fun onLoginSuccess(firstName: String, lastName: String, imageUrl: String)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}


