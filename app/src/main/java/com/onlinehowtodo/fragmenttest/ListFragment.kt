package com.onlinehowtodo.fragmenttest


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onlinehowtodo.fragmenttest.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productList = binding.productList.apply {

            layoutManager = LinearLayoutManager(activity)

            adapter = ProductAdapter {
//                val bundle = Bundle()
//                bundle.putInt("ID", it.id)
                findNavController().navigate(ListFragmentDirections.actionHomeToDetail(it.id))
            }
            setHasFixedSize(true)
        }
        (productList.adapter as ProductAdapter).submitList(products)
    }
}
