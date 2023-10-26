package com.example.retrofitloginlearn.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitloginlearn.model.Products
import com.example.retrofitloginlearn.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ListViewModel: ViewModel() {
    var repo = Repository()
    val productList: MutableLiveData<Response<Products>> = MutableLiveData()

    fun getProduct(){
        viewModelScope.launch {
            productList.value = repo.getProducts()
        }
    }

    fun searchProduct(name: String){
        viewModelScope.launch {
            productList.value = repo.getProductSearch(name)
        }
    }

}