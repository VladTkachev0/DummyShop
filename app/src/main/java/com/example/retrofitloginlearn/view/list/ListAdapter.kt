package com.example.retrofitloginlearn.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitloginlearn.R
import com.example.retrofitloginlearn.databinding.ItemBinding
import com.example.retrofitloginlearn.model.ProductX
import com.example.retrofitloginlearn.model.Products
import com.squareup.picasso.Picasso


class ListAdapter: RecyclerView.Adapter<ListAdapter.ListHolder>() {

    var listProduct = emptyList<ProductX>()

    class ListHolder(item: View): RecyclerView.ViewHolder(item){

        val binding = ItemBinding.bind(item)

            fun bind(product: ProductX) = with(binding){
                tvProductName.text = product.title
                Picasso.get().load(product.thumbnail).into(imageView3)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListHolder(view)
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(listProduct[position])

        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment(
                listProduct[position].brand,
                listProduct[position].category,
                listProduct[position].description,
                listProduct[position].discountPercentage.toFloat(),
                listProduct[position].price,
                listProduct[position].rating.toFloat(),
                listProduct[position].stock,
                listProduct[position].thumbnail,
                listProduct[position].title
            )
            it.findNavController().navigate(action)
        }
    }

    fun setList(product: Products){
        listProduct = product.products.toList()
        notifyDataSetChanged()

    }
}