package uz.digital.taskapp

import android.content.Context
import android.content.SharedPreferences


private const val NAME = "app"
private const val MYACTIVITY = "Activitiess"

class PrefManager {


    companion object {

        private fun getInstance(ctx: Context): SharedPreferences {
            return ctx.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        }

        fun saveActivity(ctx: Context, activity: String) {
            var activities = getActivity(ctx)

            activities.add(activity)

            getInstance(ctx).edit().putStringSet(MYACTIVITY, activities).apply()
        }

        fun getActivity(ctx: Context): MutableSet<String> {
            return getInstance(ctx).getStringSet(MYACTIVITY, mutableSetOf()) as MutableSet<String>
        }

        fun getActivity(ctx:Context):String{

            return getInstance(ctx).getString("ACTIVITIES"))
        }

    }
}
