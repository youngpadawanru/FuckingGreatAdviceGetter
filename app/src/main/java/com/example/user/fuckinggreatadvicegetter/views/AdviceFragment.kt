package com.example.user.fuckinggreatadvicegetter.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.user.fuckinggreatadvicegetter.R
import com.example.user.fuckinggreatadvicegetter.presenters.AdvicePresenter
import kotlinx.android.synthetic.main.advice_fragment.*

class AdviceFragment : Fragment() {

    private val advicePresenter = AdvicePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.advice_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retainInstance = true
        getButton.setOnClickListener { advicePresenter.getAdvice() }
        saveButton.setOnClickListener { advicePresenter.saveAdvice(textView.text.toString()) }
    }

    fun setAdviceText(text: String) {
        textView.text = text
    }

    fun showErrorMessage() {
        Toast.makeText(context, "Что то пошло не так.", Toast.LENGTH_SHORT).show()
    }
}