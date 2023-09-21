package com.example.exam2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.map
import com.example.exam2.CryptoAdapter
import com.example.exam2.database.CryptoEntity
import com.example.exam2.database.CryptoRoomDatabase
import com.example.exam2.databinding.FragmentMainBinding
import com.example.exam2.model.Crypto
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    //val database: CryptoRoomDatabase by lazy { CryptoRoomDatabase.getDatabase(requireContext()) }
    //val dao = database.cryptoDao()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = CryptoAdapter()
        /*GlobalScope.launch {
            dao.insert(viewModel.cryptoData.map { it })
        }*/



        return binding.root
    }
}
//fun Crypto.toCryptoEntity() = CryptoEntity(
//    name = name,
//    symbol = symbol,
//    imageUrl = imageUrl,
//    currentPrice = currentPrice,
//    marketCap = marketCap,
//    highestValue24h = highestValue24h,
//    priceChangePercentage24h = priceChangePercentage24h,
//    marketCapPercentageChange24h = marketCapPercentageChange24h,
//    lowestValue24h = lowestValue24h)