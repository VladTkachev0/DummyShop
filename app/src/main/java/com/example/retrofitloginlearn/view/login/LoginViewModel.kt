package com.example.retrofitloginlearn.view.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitloginlearn.model.AuthRequest
import com.example.retrofitloginlearn.model.User
import com.example.retrofitloginlearn.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class LoginViewModel: ViewModel() {
    var repo = Repository()
    val userList: MutableLiveData<User> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()
    fun getUser(authRequest: AuthRequest){
        viewModelScope.launch {
            try {
                userList.value = repo.getUser(authRequest)
            }
            catch (e: HttpException) {
                error.postValue("Ошибка: ${e.message}")
            } catch (e: Exception) {
                error.postValue("Неожиданная ошибка: ${e.message}")
            }


        }
    }
}