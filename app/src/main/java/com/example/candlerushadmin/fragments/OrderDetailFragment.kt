package com.example.candlerushadmin.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.candlerushadmin.Constants
import com.example.candlerushadmin.R
import com.example.candlerushadmin.databinding.FragmentOrderDetailBinding
import com.example.candlerushadmin.models.PlaceOrderModel
import com.example.candlerushadmin.models.RegisterModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 * Use the [OrderDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderDetailFragment : Fragment() {
    lateinit var binding : FragmentOrderDetailBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderDetailBinding.inflate(layoutInflater)
        arguments?.let {
          var orderModel = it.getSerializable(Constants.orderdetails) as PlaceOrderModel
            Glide.with(requireActivity())
                .load(orderModel?.productImage)
                .centerCrop()
                .placeholder(R.drawable.candle)
                .into(binding.ivImage)
            binding.tvProductName.setText(orderModel?.productName)
            binding.tvProductDescription.setText(orderModel?.productDes)
            binding.tvProductPrice.setText(orderModel?.productPrice.toString())
            binding.tvProductColour.setText(orderModel?.productColor)
            binding.tvProductFragrance.setText(orderModel?.productFragrance)
            binding.tvProductColour.setText(orderModel?.productColor)
            binding.tvProductShape.setText(orderModel?.productShape)
            binding.tvProductSize.setText(orderModel?.productSize)
            println("UserID: ${orderModel.userid}")
            db.collection("users").document(orderModel?.userid.toString()).get().addOnCompleteListener {
                if(it.isSuccessful){
                    var userData = it.result.toObject(RegisterModel::class.java)
                    binding.tvUserName.setText(userData?.username)
                    binding.tvUserEmail.setText(userData?.useremail)
                }
            }
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderDetailFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}