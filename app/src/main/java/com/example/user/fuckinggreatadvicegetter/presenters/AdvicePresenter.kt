package com.example.user.fuckinggreatadvicegetter.presenters

import com.example.user.fuckinggreatadvicegetter.model.database.DBController
import com.example.user.fuckinggreatadvicegetter.model.Advice
import com.example.user.fuckinggreatadvicegetter.model.network.RetrofitFactory
import com.example.user.fuckinggreatadvicegetter.views.AdviceFragment
import com.example.user.fuckinggreatadvicegetter.views.MainActivity
import kotlinx.coroutines.*

class AdvicePresenter(private val adviceFragment: AdviceFragment) {

    private val dbController = DBController()

    fun getAdvice() {
        val service = RetrofitFactory.getService()
        GlobalScope.launch(Dispatchers.Main)
        {
            val request = service.getData()
            try {
                val response = request.await()
                adviceFragment.setAdviceText(response.text)
            } catch (e: Throwable) {
                adviceFragment.showErrorMessage()
                e.printStackTrace()
            }
        }
    }

    fun saveAdvice(string: String) {
        val ad = Advice()
        val adapter = (adviceFragment.activity as MainActivity).getAdapter()
        ad.text = string
        dbController.add(ad)
        adapter!!.onItemAdd()
    }
}