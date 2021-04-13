package com.example.rocketapp.managers



import com.ddtech.ddverifier.managers.Globals
import com.example.meallist.model.*


import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "NAME_SHADOWING")
class ServiceManager {

    fun getMenuList(callbackSuccess: (response: Menu) -> Unit, callbackFailure: (response: ArrayList<String>) -> Unit)
    {



        val call = ServiceConnector().Run().getMenuList()
        call.enqueue(callback({ response ->

            response?.body()?.let {

                val plainBody: String = it
                val responseConvert: Menu = Gson().fromJson(plainBody, Menu::class.java)

                callbackSuccess(responseConvert)
                return@callback
            }
        },
                { throwable ->
                    throwable?.let {
                        var errors = ArrayList<String>()
                        errors.add(it.localizedMessage)
                        callbackFailure(errors)
                        return@callback
                    }
                }
        ))
    }

    fun getCategories(callbackSuccess: (response: Categories) -> Unit, callbackFailure: (response: ArrayList<String>) -> Unit)
    {



        val call = ServiceConnector().Run().getCategories()
        call.enqueue(callback({ response ->

            response?.body()?.let {

                val plainBody: String = it
                val responseConvert: Categories = Gson().fromJson(plainBody, Categories::class.java)

                callbackSuccess(responseConvert)
                return@callback
            }
        },
            { throwable ->
                throwable?.let {
                    var errors = ArrayList<String>()
                    errors.add(it.localizedMessage)
                    callbackFailure(errors)
                    return@callback
                }
            }
        ))
    }

    fun getFilters(selected : String,callbackSuccess: (response: SelectedCategory) -> Unit, callbackFailure: (response: ArrayList<String>) -> Unit)
    {



        val call = ServiceConnector().Run().getfilter(selected)
        call.enqueue(callback({ response ->

            response?.body()?.let {

                val plainBody: String = it
                val responseConvert: SelectedCategory = Gson().fromJson(plainBody, SelectedCategory::class.java)

                Globals.shared.selectedCategory = responseConvert.meals
                callbackSuccess(responseConvert)

                return@callback
            }
        },
            { throwable ->
                throwable?.let {
                    var errors = ArrayList<String>()
                    errors.add(it.localizedMessage)
                    callbackFailure(errors)
                    return@callback
                }
            }
        ))
    }

    fun getDetail(id : String,callbackSuccess: (response: Detail) -> Unit, callbackFailure: (response: ArrayList<String>) -> Unit)
    {



        val call = ServiceConnector().Run().getDetail(id)
        call.enqueue(callback({ response ->

            response?.body()?.let {

                val plainBody: String = it
                val responseConvert: Detail = Gson().fromJson(plainBody, Detail::class.java)
  //              Globals.shared.selectedMeal = responseConvert.meals
                callbackSuccess(responseConvert)

                return@callback
            }
        },
            { throwable ->
                throwable?.let {
                    var errors = ArrayList<String>()
                    errors.add(it.localizedMessage)
                    callbackFailure(errors)
                    return@callback
                }
            }
        ))
    }


}
