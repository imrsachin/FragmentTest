package com.onlinehowtodo.fragmenttest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.onlinehowtodo.fragmenttest.databinding.FragmentDetailBinding
import com.onlinehowtodo.fragmenttest.databinding.ListItemBinding


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: Product? = null
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        product = products.find { it.id == args.id }

        product?.let {
//            val include = ListItemBinding.inflate(LayoutInflater.from(view.context))
            with(binding) {
                include.name.text = it.name
                include.price.text = getString(R.string.product_price, it.price)
                include.description.text = it.shortDescription
                binding.fullDescription.text = it.longDescription
                binding.include.image.setImageResource(it.imageId)

                binding.buy.setOnClickListener {v->
//                    val bundle = Bundle()
//                    bundle.putInt("ID", it.id)
                    findNavController().navigate(DetailFragmentDirections.actionDetailToCheckout(it.id))
                }
            }
        }
    }
}
