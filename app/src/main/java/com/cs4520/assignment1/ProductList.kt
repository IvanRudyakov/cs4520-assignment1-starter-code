package com.cs4520.assignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs4520.assignment1.databinding.FragmentLoginBinding
import com.cs4520.assignment1.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment() {

    private lateinit var binding: ProductListFragmentBinding;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductListFragmentBinding.inflate(inflater, container, false)
        binding.productListView.layoutManager = LinearLayoutManager(context)
        binding.productListView.adapter = ProductAdapter(getProductsList());
        return binding.root
    }

    private fun getProductsList(): List<Product> {
        return productsDataset.map {
            val name = it[0] as String;
            val type = it[1] as String;
            val exp = it[2] as String?;
            val price = it[3] as Int;
            when (type) {
                "Equipment" -> Equipment(name, price, exp)
                "Food" -> Food(name, price, exp)
                else -> throw Exception("Invalid Product")
            }
        }
    }

}