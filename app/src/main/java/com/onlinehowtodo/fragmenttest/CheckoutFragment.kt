package com.onlinehowtodo.fragmenttest


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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

        val args = CheckoutFragmentArgs.fromBundle(requireArguments())
        val factory = CheckOutViewModelFactory(args.id)
        val viewModel: CheckOutViewModel by viewModels(factoryProducer = { factory })
        val product = viewModel.product
        product.observe(viewLifecycleOwner) {
            setData(binding,it)
        }

        binding.incQty.setOnClickListener {
            viewModel.addQty()
        }
        binding.reduceQty.setOnClickListener {
            viewModel.reduceQty()
        }

        viewModel.qty.observe(viewLifecycleOwner){
            binding.quantity.text = it.toString()
//            binding.orderTotal.text =
//                getString(R.string.order_total, price * viewModel.qty)
        }
    }

    fun setData(binding: FragmentCheckoutBinding,product: Product){
        with(product){
            binding.price.text = getString(R.string.product_price, price)
            binding.image.setImageResource(imageId)

            binding.checkout.setOnClickListener {
                findNavController().navigate(CheckoutFragmentDirections.actionCheckoutToThanks())
            }
        }
    }
}
