package com.example.user.fuckinggreatadvicegetter.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.user.fuckinggreatadvicegetter.R
import com.example.user.fuckinggreatadvicegetter.presenters.AdvicePresenter

class AdviceFragment : Fragment() {

    private lateinit var textView: TextView
    private val advicePresenter = AdvicePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.advice_fragment, container, false)
        retainInstance = true
        if (savedInstanceState == null) {
            advicePresenter.getAdvice()
        }
        textView = view.findViewById(R.id.text)
        val getButton = view.findViewById<Button>(R.id.getbutton)
        val saveButton = view.findViewById<Button>(R.id.savebutton)
        getButton.setOnClickListener { advicePresenter.getAdvice() }
        saveButton.setOnClickListener { advicePresenter.saveAdvice(textView.text.toString()) }
        return view
    }

    fun setAdviceText(text: String) {
        textView.text = text
    }

    fun showErrorMessage() {
        Toast.makeText(context, "Что то пошло не так.", Toast.LENGTH_SHORT).show()
    }
}