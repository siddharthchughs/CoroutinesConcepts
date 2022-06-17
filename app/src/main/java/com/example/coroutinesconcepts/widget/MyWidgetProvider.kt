package com.example.coroutinesconcepts.widget

import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.widget.RemoteViews
import com.example.coroutinesconcepts.R

class MyWidgetProvider : AppWidgetProvider() {

    private val PREFERENCE_KEY="PREFER_KEY"
    private val ITEM_KEY="ITEM_KEY"

    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        val special = arrayListOf(Special(1,"Butter cake"), Special(2,"Choclate cake"))
        val  sharedPreferences: SharedPreferences?
            = context?.getSharedPreferences(PREFERENCE_KEY,Context.MODE_PRIVATE)
        var currentSpecial: Int? = sharedPreferences?.getInt(ITEM_KEY,0)

        if(currentSpecial== special.size-1){
            currentSpecial =0
        }
        else{
            if (currentSpecial != null) {
                currentSpecial++
            }
        }

        sharedPreferences?.edit().apply {
            this?.putInt(ITEM_KEY,currentSpecial!!)
            this?.apply()
        }

        val specialName = special[currentSpecial!!].name
        if (appWidgetIds != null) {
            for (specialWidget in appWidgetIds){
                val remoteViwes = RemoteViews(context?.packageName, R.layout.layout_widget)
                remoteViwes.setTextViewText(R.id.tvData,specialName)
                appWidgetManager?.updateAppWidget(specialWidget,remoteViwes)
            }
            val intent = Intent(context,MyWidgetProvider::class.java)
            intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,appWidgetIds)
            val pendingIntent = PendingIntent.getBroadcast(
                context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT
            )
            val second = 3
            val alarmManager: AlarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setExact(AlarmManager.RTC, System.currentTimeMillis() + (second*1000),pendingIntent)

        }

    }
}

//                remoteViwes.setOnClickPendingIntent(R.id.button,pendingIntent)


