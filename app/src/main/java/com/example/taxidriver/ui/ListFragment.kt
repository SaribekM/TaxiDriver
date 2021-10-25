package com.example.taxidriver.ui

import android.os.Bundle
import android.view.*
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.taxidriver.service.DriverService
import com.example.taxidriver.MainActivity
import com.example.taxidriver.R
import com.example.taxidriver.adapters.ListViewAdapter

class ListFragment : Fragment() {
    lateinit var listAdapter: ListViewAdapter

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listOfDrivers = DriverService.listOfDrivers
        val context = context as MainActivity
        listAdapter = ListViewAdapter(context, listOfDrivers)
        val listView = context.findViewById<ListView>(R.id.listView)
        listView.adapter = listAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list_fragment_to_recycler_fragment, menu);

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        if (transaction != null) {
            transaction.replace(R.id.container, RecyclerFragment())
            transaction.disallowAddToBackStack()
            transaction.commit()
        }
        return super.onOptionsItemSelected(item)
    }
}