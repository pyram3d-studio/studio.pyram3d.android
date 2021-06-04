package app.pyram3d.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.pyram3d.R
import app.pyram3d.data.Pyramid

class HomeViewModel : ViewModel() {

    private val _cardCuriosity = MutableLiveData<Int>().apply { value = arrayOf(
        R.string.fragment_home_curiosity_1,
        R.string.fragment_home_curiosity_2,
        R.string.fragment_home_curiosity_3
    ).random() }

    val cardSuggestion: LiveData<Int> = _cardCuriosity
}