package ru.startandroid.develop.dynamicactionbar

import android.os.Bundle
import android.view.*

class Fragment2 : androidx.fragment.app.Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment2, null)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment2, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}