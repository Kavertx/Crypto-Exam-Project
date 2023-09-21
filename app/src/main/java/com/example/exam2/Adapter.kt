package com.example.exam2

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exam2.databinding.FragmentMainBinding
import com.example.exam2.databinding.ItemListItemBinding
import com.example.exam2.model.Crypto
import com.example.exam2.ui.main.MainFragmentDirections

class CryptoAdapter : androidx.recyclerview.widget.ListAdapter<Crypto,
        CryptoAdapter.CryptoViewHolder>(DiffCallback){

    companion object DiffCallback : DiffUtil.ItemCallback<Crypto>() {
        override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem.symbol == newItem.symbol }
    }

    class CryptoViewHolder(val binding: ItemListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(crypto: Crypto){
            binding.apply {
                cryptoName.text = crypto.name
                cryptoSymbol.text = crypto.symbol
                cryptoPrice.text = crypto.currentPrice.toString()

                Glide
                    .with(this.root.context)
                    .load(crypto.imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(imageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        return CryptoViewHolder(ItemListItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val currentCrypto = getItem(position)
        holder.bind(currentCrypto)
        holder.binding.root.setOnClickListener {
            val cryptoLogo = currentCrypto.imageUrl
            val cryptoName = currentCrypto.name
            val cryptoSymbol = currentCrypto.symbol
            val cryptoPrice = currentCrypto.currentPrice
            val cryptoMarketCap = currentCrypto.marketCap
            val cryptoHighest = currentCrypto.highestValue24h
            val cryptoPriceChange = currentCrypto.priceChangePercentage24h
            val cryptoMarketCapChange = currentCrypto.marketCapPercentageChange24h
            val cryptoLowest = currentCrypto.lowestValue24h
            val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(
                cryptoLogo,
                cryptoName,
                cryptoSymbol,
                cryptoPrice.toString(),
                cryptoMarketCap,
                cryptoHighest.toString(),
                cryptoPriceChange.toString(),
                cryptoMarketCapChange.toString(),
                cryptoLowest.toString()
            )
            holder.itemView.findNavController().navigate(action)
        }
    }



}