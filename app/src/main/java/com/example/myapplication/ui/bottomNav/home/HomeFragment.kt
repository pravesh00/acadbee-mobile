package com.example.myapplication.ui.bottomNav.home

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.FileAdapter
import com.example.myapplication.data.File
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.FileActivity
import com.example.myapplication.util.OnItemClickListener
import com.example.myapplication.viewmodel.HomeViewModel

class HomeFragment : Fragment(), OnItemClickListener<File> {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel = HomeViewModel()
    private lateinit var list : ArrayList<File>
    private lateinit var adapter: FileAdapter
    private lateinit var buttonClickListener: OnItemClickListener<File>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        list = ArrayList<File>()

        buttonClickListener = object : OnItemClickListener<File> {
            override fun onItemClick(position: Int, data: File) {
                viewModel.downLoadFile(data, requireContext())
            }
        }

        adapter = FileAdapter(list,this, buttonClickListener)
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
        this.activity?.let { viewModel.refresh(it.applicationContext) }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int, data: File) {
        val intent = Intent(this@HomeFragment.activity, FileActivity::class.java);
        val bundle = Bundle();
        bundle.putParcelable("file", data)
        intent.putExtras(bundle)
        requireContext().startActivity(intent)
    }
}