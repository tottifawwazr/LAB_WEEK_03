package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class ListFragment : Fragment(R.layout.fragment_list), View.OnClickListener {

    private lateinit var coffeeListener: CoffeeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) {
            coffeeListener = context
        } else {
            throw RuntimeException("Must implement CoffeeListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte)
        )
        coffeeList.forEach { it.setOnClickListener(this) }
    }

    override fun onClick(v: View?) {
        v?.let { coffee ->
            coffeeListener.onSelected(coffee.id)
        }
    }

    interface CoffeeListener {
        fun onSelected(id: Int)
    }
}
