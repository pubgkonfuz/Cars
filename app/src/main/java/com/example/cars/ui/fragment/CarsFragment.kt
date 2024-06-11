package com.example.cars.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cars.databinding.FragmentCarsBinding
import com.example.cars.model.Car
import com.example.cars.ui.adapter.CarsAdapter


class CarsFragment : Fragment() {

    private lateinit var binding: FragmentCarsBinding
    private val carAdapter = CarsAdapter(this::click)

    private val list = listOf(
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2020),
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2021),
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2023),
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2024),
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2019),
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2018),
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2022),
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2017),
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2015),
        Car("https://wpde.com/resources/media2/16x9/full/1024/center/80/7ab4f559-b123-4754-afb4-779fabea1de2-large16x9_AP23017553965691.jpg", "Media", 2024)
        )
    private fun click(car: Car) {
        findNavController().navigate(CarsFragmentDirections.actionCarsFragmentToDetailFragment(car))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCarsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }
    private fun initialize() {
        binding.rvCars.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = carAdapter
            carAdapter.submitList(list)
        }
    }

}