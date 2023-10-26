package com.example.retrofitloginlearn.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.retrofitloginlearn.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso


class DetailsFragment : Fragment() {

    private lateinit var _binding: FragmentDetailsBinding
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            Picasso.get().load(args.thumbnail).into(imageProduct)
            tvTitle.text = "${args.category} ${args.brand} ${args.title}"
            tvPrice.text = "Price: ${args.price}$ (Discount ${args.discountPercentage}%)"
            tvRating.text = "${args.rating}★"
            tvDescription.text = "${args.description}"
            tvStock.text = "Stock: ${args.stock} pieces"

        }
    }
}
