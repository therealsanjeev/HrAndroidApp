package com.therealsanjeev.hrandroidapp.DialogBox

import android.app.Dialog
import android.app.AlertDialog
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText

import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import kotlinx.android.synthetic.main.dialogbox.view.*
import java.lang.ClassCastException
import com.therealsanjeev.hrandroidapp.R

class DialogBox(): AppCompatDialogFragment() {

    private lateinit var name: EditText
    private lateinit var position: EditText
    private lateinit var salary: EditText
    private lateinit var type:EditText
    private lateinit var listener: ExampleDialogListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater: LayoutInflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.dialogbox,null)
        builder.setView(view)
            .setNegativeButton("Cancel"){dialogInterface, it ->
                Toast.makeText(
                    context,
                    "Canceled",
                    Toast.LENGTH_SHORT
                ).show()}
            .setPositiveButton("save"){dialogInterface, it ->
                val name = name.text.toString()
                val position = position.text.toString()
                val salary = salary.text.toString()
                val type =type.text.toString()
                listener.applyTexts(name, position, salary,type)
            }

        name = view.name_et
        position = view.position_et
        salary = view.salary_et
        type=view.type_et

        return builder.create()
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            listener = activity as ExampleDialogListener
        }catch (exception: ClassCastException){
            throw ClassCastException(context.toString())
        }

    }

    interface ExampleDialogListener {
        fun applyTexts(name: String?, position: String?, salary: String?,type:String?)
    }
}