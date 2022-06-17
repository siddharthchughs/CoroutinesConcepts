package com.example.coroutinesconcepts.customviwes

import android.app.ActionBar
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.setPadding

class MyCustomTextView(context: Context) : AppCompatTextView(context) {

     constructor(context:Context,colorName:String,colorID:Int):this(context){
        val paddingSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F,context.resources.displayMetrics).toInt()
          val layoutParams : LinearLayout.LayoutParams =
               LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
          layoutParams.setMargins(16,8,16,8)
          setLayoutParams(layoutParams)
          setPadding(paddingSize)

          if(Build.VERSION.SDK_INT>=23){
               setBackgroundColor(resources.getColor(colorID,null))
          }else{
          setBackgroundColor(colorID)
     }
     setText(colorName)
     textAlignment = TEXT_ALIGNMENT_CENTER

     setOnClickListener(object :View.OnClickListener{
         override fun onClick(view: View?) {
             Toast.makeText(context,"Click ",Toast.LENGTH_SHORT).show()
         }

     })
     }

}