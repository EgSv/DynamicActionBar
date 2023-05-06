package ru.startandroid.develop.dynamicactionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val MENU_ID = 1

    private var chbAddDel: CheckBox? = null
    private var chbVisible: CheckBox? = null

    private var frag1: Fragment? = null
    private var frag2: Fragment? = null
    private var frag: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chbAddDel = findViewById(R.id.chbAddDel)
        chbVisible = findViewById(R.id.chbVisible)

        frag1 = Fragment1()
        frag = frag1
        frag2 = Fragment2()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        menu!!.setGroupVisible(R.id.groupVsbl, chbVisible!!.isChecked)
        if (chbAddDel!!.isChecked) {
            menu.add(0, MENU_ID, 0, R.string.menu_item1)
                .setIcon(android.R.drawable.ic_delete)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS
                        or MenuItem.SHOW_AS_ACTION_WITH_TEXT)
        } else {
            menu.removeItem(MENU_ID)
        }
        return true
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.chbAddDel,
            R.id.chbVisible -> invalidateOptionsMenu()
            R.id.btnFrag -> {
                frag = if (frag === frag1) frag2 else frag1
                supportFragmentManager.beginTransaction().replace(R.id.cont, frag!!)
                    .commit()
            }
            else -> {}
        }
    }
}