//package com.example.coroutinesconcepts.widget
//
//import android.appwidget.AppWidgetManager
//import android.appwidget.AppWidgetProvider
//import android.content.Context
//import android.util.Log
//import android.widget.RemoteViews
//
//
//class DemoWidgetProvider : AppWidgetProvider() {
//
//    private val PREFERENCE_KEY="PREFER_KEY"
//    private val ITEM_KEY="ITEM_KEY"
//
//    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
//        super.onUpdate(context, appWidgetManager, appWidgetIds)
//
//       Log.i("tHe","update")
//        val foodItem = Special(R.string.pizza, R.drawable.pizza)
//        val imageId: Int = foodItem.getImageId()
//        val foodName = context!!.getString(foodItem.getNameId())
//
//        for (widgetId in appWidgetIds!!) {
//            val remoteViews = RemoteViews(
//                context!!.packageName, R.layout.widget_layout
//            )
//            remoteViews.setTextViewText(R.id.food_name, foodName)
//            remoteViews.setImageViewResource(R.id.food_image, imageId)
//            appWidgetManager!!.updateAppWidget(widgetId, remoteViews)
//        }
//
//    }
//}
//
//
