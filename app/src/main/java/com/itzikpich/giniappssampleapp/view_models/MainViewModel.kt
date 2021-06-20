package com.itzikpich.giniappssampleapp.view_models


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itzikpich.giniappssampleapp.data.Repository
import com.itzikpich.giniappssampleapp.models.NumberItemType
import com.itzikpich.giniappssampleapp.models.NumberType
import com.itzikpich.giniappssampleapp.models.NumbersResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.abs


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val numberItemTypeList = MutableLiveData<List<NumberItemType>>()

    init {
        getNumbers()
    }

    fun getNumbers() {
        viewModelScope.launch {
            repository.getNumbersFromNetwork().collect { response ->
                numberItemTypeList.value = getNumberItemTypeList(response)
            }
        }
    }

    private fun getNumberItemTypeList(response: NumbersResponse) : List<NumberItemType> {
        val tempMap = mutableMapOf<Int, Int>()
        response.numberItems.sortedBy { it.number }.apply {
            this.map { numItem ->
                numItem.number // get all integers
            }.forEach { num ->
                val absolute = abs(num) // get all numbers as absolute
                if (tempMap.containsKey(absolute)) { // fill map of numbers, check if number already in map
                    tempMap[absolute] = num + tempMap[absolute]!! // equals to 0
                } else {
                    tempMap[absolute] = num
                }
            }
            return map { numItem ->
                if (numItem.number == 0 || tempMap[abs(numItem.number)] != 0) {
                    NumberItemType(numItem.number, NumberType.SINGLE)
                } else {
                    NumberItemType(numItem.number, NumberType.DOUBLE)
                }
            }
        }
    }

}