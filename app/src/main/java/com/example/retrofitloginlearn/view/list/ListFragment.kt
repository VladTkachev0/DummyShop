package com.example.retrofitloginlearn.view.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitloginlearn.R
import com.example.retrofitloginlearn.databinding.FragmentListBinding
import com.example.retrofitloginlearn.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListFragment : Fragment() {

    private lateinit var _binding: FragmentListBinding
    private val binding get() = _binding!!
    private val adapter = ListAdapter()
    private val listViewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcView.adapter = adapter
        listViewModel.getProduct()
        listViewModel.productList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it) }
        }

        binding.searchView.setOnQueryTextListener(object: OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(name: String?): Boolean {
                if (name != null) {
                    listViewModel.searchProduct(name)
                    listViewModel.productList.observe(viewLifecycleOwner){ list ->
                        list.body()?.let { adapter.setList(it) }
                    }
                }
                return true
            }

        })
    }

}
