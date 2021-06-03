package app.pyram3d.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.pyram3d.data.Pyramid

class HomeViewModel : ViewModel() {

    private val _cardText = MutableLiveData<String>().apply {  value = "¿Sabías qué...?" }
    private val _buttonText = MutableLiveData<String>().apply { value = "Saber más" }
    private val _cardSuggestion = MutableLiveData<String>().apply { value = arrayOf(
        "Las pirámides de Egipto, fueron construidas hace 4 mil años, hoy siendo la maravilla más antigua y la única que se conserva.",
        "El primer arquitecto registrado en la historia, es Imhotep, responsable de la construcción de la pirámide escalonada de Zoser.",
        "Las pirámides se pueden clasificar según el número de lados que tiene su base: triángular, cuadrangular, pentagonal y hexagonal."
    ).random() }

    private val _pyramid = MutableLiveData<Pyramid>().apply { value = Pyramid(138.0, 227.0, 4) }

    val cardText: LiveData<String> = _cardText
    val buttonText: LiveData<String> = _buttonText
    val cardSuggestion: LiveData<String> = _cardSuggestion

    val pyramid: LiveData<Pyramid> = _pyramid

}