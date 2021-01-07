package com.onlinehowtodo.fragmenttest


import android.os.Bundle
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
        val view = FragmentCheckoutBinding.inflate(inflater)
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: Product? = null
        val args = CheckoutFragmentArgs.fromBundle(requireArguments())
        product = products.find { it.id == args.id }

        product?.let {
            with(it) {
                binding.price.text = getString(R.string.product_price, price)
                val qty = binding.quantity
                binding.orderTotal.text =
                    getString(R.string.order_total, price.times(qty.toString().toInt()))
                binding.image.setImageResource(imageId)

                binding.checkout.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putInt("ID", this.id)
                    findNavController().navigate(R.id.action_checkout_to_thanks, bundle)
                }
            }
        }
    }
}
