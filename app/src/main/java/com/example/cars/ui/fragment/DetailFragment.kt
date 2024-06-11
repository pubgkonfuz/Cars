package com.example.cars.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.cars.R
import com.example.cars.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        arroeBack()
    }

    private fun arroeBack() {
        binding.ivArrowDetail.setOnClickListener {
            findNavController().navigate(R.id.carsFragment)
        }
    }

    private fun getData() {
        Glide.with(binding.ivImageDetail).load(args.model.image)
            .into(binding.ivImageDetail)
        binding.tvNameDetail.text = args.model.name
        binding.tvYearDetail.text = args.model.year.toString()
    }

}