package com.example.exam2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.exam2.R
import com.example.exam2.databinding.FragmentDetailsBinding

class DetailsFragment:Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    private val args: DetailsFragmentArgs by navArgs()
    private var _binding: FragmentDetailsBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)
        binding.apply {
            tvName.text = String.format(getString(R.string.crypto_name), args.cryptoName)
            tvSymbol.text = String.format(getString(R.string.crypto_symbol), args.cryptoSymbol)
            tvPrice.text = String.format(getString(R.string.crypto_price), args.cryptoPrice)
            tvMarketCap.text = String.format(getString(R.string.crypto_market_cap), args.cryptoMarketCap.toString())
            tvHighestValue24.text = String.format(getString(R.string.crypto_highest), args.cryptoHighest)
            tvLowestValue24.text = String.format(getString(R.string.crypto_lowest), args.cryptoLowest)
            tvPercentageMarketCapChange.text = String.format(getString(R.string.crypto_percent_market_cap), args.cryptoMarketCapChange)
            tvPercentagePriceChange.text = String.format(getString(R.string.crypto_percent_price), args.cryptoPriceChange)
            Glide
                .with(this.root.context)
                .load(args.cryptoLogo)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(logo)
        }
        return binding.root
    }

}