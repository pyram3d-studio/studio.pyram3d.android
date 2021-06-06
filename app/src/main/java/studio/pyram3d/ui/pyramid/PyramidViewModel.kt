package studio.pyram3d.ui.pyramid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import studio.pyram3d.data.Pyramid

class PyramidViewModel : ViewModel() {
    private val _pyramid = MutableLiveData<Pyramid>().apply { value = Pyramid(138.0, 227.0, 4) }

    val pyramid: LiveData<Pyramid> = _pyramid
}