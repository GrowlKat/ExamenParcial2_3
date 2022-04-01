package com.example.examenparcial1_3

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class TipoAdapter(context: Context) : RecyclerView.Adapter<TipoAdapter.TipoViewHolder>()
{
    //Devuelve el string-array de string-array.xml, especificando los tipos
    private val tipos: List<String> = context.resources.getStringArray(R.array.tipos).toList().sorted()

    class TipoViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun getItemCount(): Int = tipos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipoViewHolder
    {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

        layout.accessibilityDelegate = Accessibility
        return TipoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TipoViewHolder, position: Int)
    {
        val item = tipos[position]
        val context = holder.view.context
        holder.button.text = item
    }

    companion object Accessibility : View.AccessibilityDelegate()
    {
        override fun onInitializeAccessibilityNodeInfo(host: View?, info: AccessibilityNodeInfo?)
        {
            super.onInitializeAccessibilityNodeInfo(host, info)
            val customString = host?.context?.getString(R.string.look_up_word)
            val customClick = AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString)
            info?.addAction(customClick)
        }
    }
}