//------Generated by the Framework and must not be changed-----//
//------Util Date Functions-----//
package br.ufc.poc2.model.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class DateUtil {

    companion object {
        // Based on Circadian rhythm
        // It all starts with the night cycle
        const val START_HOUR = 18
        const val END_HOUR = 17

        @SuppressLint("SimpleDateFormat")
        fun getMainDateFormatter(): SimpleDateFormat {
            return SimpleDateFormat("yyyyMMdd-HH:mm:ss")
        }

        fun getBeginDateForRegisters(): Date {
            val cal = Calendar.getInstance()
            cal.add(Calendar.DAY_OF_MONTH, -1)
            cal.set(Calendar.HOUR_OF_DAY, START_HOUR)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)
            return cal.time
        }

        fun getEndDateForRegisters(): Date {
            val cal = Calendar.getInstance()
            cal.set(Calendar.HOUR_OF_DAY, END_HOUR)
            cal.set(Calendar.MINUTE, 59)
            cal.set(Calendar.SECOND, 59)
            return cal.time
        }

        fun getBeginDateForRegistersLong(): Long {
            return getBeginDateForRegisters().time
        }

        fun getEndDateForRegistersLong(): Long {
            return getEndDateForRegisters().time
        }

        fun getMillisecondsFormatted(milli: Long): String{
            val format = String.format(
                "%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milli),
                TimeUnit.MILLISECONDS.toMinutes(milli) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milli)),
                TimeUnit.MILLISECONDS.toSeconds(milli) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milli))
            )
            return format
        }

        fun getSecondsFormatted(seconds: Long):String{
            return String.format(
                "%02d:%02d:%02d",
                TimeUnit.SECONDS.toHours(seconds),
                TimeUnit.SECONDS.toMinutes(seconds) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(seconds)),
                TimeUnit.SECONDS.toSeconds(seconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(seconds))
            )
        }
    }
}