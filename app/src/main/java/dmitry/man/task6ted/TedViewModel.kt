package dmitry.man.task6ted

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TedViewModel : ViewModel() {

    private val _items = MutableLiveData<List<TedVideo>>()
    val items: LiveData<List<TedVideo>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = TedApiImpl.getListOfTed()
        }
    }
}