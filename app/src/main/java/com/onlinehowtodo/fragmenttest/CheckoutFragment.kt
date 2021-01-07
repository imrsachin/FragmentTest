package com.onlinehowtodo.fragmenttest


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.onlinehowtodo.fragmenttest.databinding.FragmentCheckoutBinding


class CheckoutFragment : Fragment() {

    lateinit var binding: FragmentCheckoutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: Product? = null
        val args = CheckoutFragmentArgs.fromBundle(requireArguments())
        product = products.find { it.id == args.id }
        Log.d("checkoutfrag", "onViewCreated:${args.id} $product")

        product?.let {
            with(it) {
                binding.price.text = getString(R.string.product_price, price)
                binding.quantity.text = 1.toString()
                binding.orderTotal.text =
                    getString(R.string.order_total,price )
                binding.image.setImageResource(imageId)

                binding.checkout.setOnClickListener {
                    findNavController().navigate(CheckoutFragmentDirections.actionCheckoutToThanks())
                }
            }
        }
    }
}
