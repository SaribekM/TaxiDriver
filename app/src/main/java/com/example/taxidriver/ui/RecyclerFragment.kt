package com.example.taxidriver.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.taxidriver.MainActivity
import com.example.taxidriver.R
import com.example.taxidriver.adapters.DriverAdapter
import com.example.taxidriver.model.Driver
import com.example.taxidriver.service.DriverDiffCallback
import com.example.taxidriver.service.DriverService

class RecyclerFragment : Fragment() {
    private var newDriverList =
        mutableListOf(
            Driver("CHUCK NORRIS", R.drawable.norris, 4.5F, "Earth"),
            Driver("Dicaprio", R.drawable.dicaprio, 3.7F, "Yaravan"),
            Driver("Brad Pitt", R.drawable.bradpitt, 4.5F, "Aparan"),
            Driver("Nicolas Cage", R.drawable.cage, 1.6F, "Sisian"),
            Driver("Robert De Niro", R.drawable.deniro, 4.5F, "Gyumri"),
            Driver("Keanu Reaves", R.drawable.keanureeves, 4.8F, "Hrazdan"),
        )
    lateinit var driverAdapter: DriverAdapter

    companion object {
        fun newInstance(): RecyclerFragment {
            return RecyclerFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val root = inflater.inflate(R.layout.fragment_recycler, container, false);
        val btnInsert = root.findViewById<Button>(R.id.buttonInsert)
        val btnRemove = root.findViewById<Button>(R.id.buttonRemove)
        btnInsert.setOnClickListener { insertData(newDriverList) }
        btnRemove.setOnClickListener { removeData(newDriverList) }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listOfDrivers = DriverService.listOfDrivers
        val context = context as MainActivity
        driverAdapter = DriverAdapter(context, listOfDrivers)
        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        val recyclerView = context.findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = driverAdapter

    }


    fun insertData(newList: List<Driver>) {
        val listOfDrivers = DriverService.listOfDrivers
        Log.d("Insert:    ", "newList = $newList")
        val driverDiffCallback = DriverDiffCallback(listOfDrivers, newList)
        val diffResult = DiffUtil.calculateDiff(driverDiffCallback)
        listOfDrivers.addAll(newList)
        diffResult.dispatchUpdatesTo(driverAdapter)
    }

    fun removeData(newList: List<Driver>) {
        val listOfDrivers = DriverService.listOfDrivers
        Log.d("Remove:    ", "newList = $newList")
        val driverDiffCallback = DriverDiffCallback(listOfDrivers, newList)
        val diffResult = DiffUtil.calculateDiff(driverDiffCallback)
        listOfDrivers.removeAt(0)
        diffResult.dispatchUpdatesTo(driverAdapter)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_recycler_fragment_to_list_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        if (transaction != null) {
            transaction.replace(R.id.container, ListFragment())
            transaction.disallowAddToBackStack()
            transaction.commit()
        }
        return super.onOptionsItemSelected(item)
    }

}