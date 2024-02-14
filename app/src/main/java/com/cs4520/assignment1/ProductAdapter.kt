package com.cs4520.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.databinding.ProductListItemBinding

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    class ViewHolder(val binding: ProductListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.nameText.text = product.name;
            binding.priceText.text = "$ " + product.price.toString();
            binding.expText.text = product.expiryDate;

            binding.expText.visibility = if(product.expiryDate == null) View.GONE else View.VISIBLE;

            val backgroundColor = when (product) {
                is Equipment -> R.color.light_red
                is Food -> R.color.light_yellow
            }
            binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, backgroundColor))

            val imageResource = when (product) {
                is Equipment -> R.drawable.tools
                is Food -> R.drawable.food
            }
            binding.image.setImageResource(imageResource)
        }
    }
}