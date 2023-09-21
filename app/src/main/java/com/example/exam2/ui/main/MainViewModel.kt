package com.example.exam2.ui.main

import androidx.lifecycle.*
import com.example.exam2.CryptoApi
import com.example.exam2.database.CryptoDao
import com.example.exam2.database.CryptoEntity
import com.example.exam2.model.Crypto
import kotlinx.coroutines.launch

 class MainViewModel/*(private val cryptoDao: CryptoDao)*/ : ViewModel() {
    private val _cryptoData = MutableLiveData<List<Crypto>>()
    val cryptoData: LiveData<List<Crypto>> = _cryptoData
    val errorMessage = "Error retrieving crypto data"
    //val allCrypto: LiveData<List<CryptoEntity>> = cryptoDao.getAll().asLiveData()


    init {
        getCryptoData()
       // insertCrypto(cryptoData.toCryptoEntity())
    }

    private fun getCryptoData(){
        viewModelScope.launch {
            try {
                _cryptoData.value = CryptoApi.retrofitService.getCrypto()
            }catch (e:Exception){
                //Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                _cryptoData.value = listOf()
            }
        }
    }

   /* private fun insertCrypto(crypto: List<CryptoEntity>){
        viewModelScope.launch{
            //cryptoDao.insert(crypto)
        }
    }*/



}