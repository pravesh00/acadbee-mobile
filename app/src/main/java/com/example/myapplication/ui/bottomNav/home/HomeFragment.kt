package com.example.myapplication.ui.bottomNav.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.FileAdapter
import com.example.myapplication.data.CourseFile
import com.example.myapplication.data.File
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.viewmodel.HomeViewModel
import java.lang.Thread.sleep

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel = HomeViewModel()
    lateinit var list : ArrayList<File>
    lateinit var adapter: FileAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        list = ArrayList<File>()
        adapter = FileAdapter(list)
        binding.fileRecycleView.adapter = adapter
        binding.fileRecycleView.layoutManager = LinearLayoutManager(this.activity)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.filesList.observe(viewLifecycleOwner, Observer {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
        viewModel.refresh()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}