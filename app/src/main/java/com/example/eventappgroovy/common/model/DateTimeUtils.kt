package com.example.eventappgroovy.common.model
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateTimeUtils {

    const val FORMAT_FULL = "format_full"
    const val FORMAT_SHORT = "format_short"
    // Add more format constants as needed

    private val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)

    fun formatDateTime(inputDateTime: String, formatType: String): String {
        val outputFormat = getOutputFormat(formatType)

        try {
            val date = inputFormat.parse(inputDateTime)
            return outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            return "Invalid Date" // Handle parsing error
        }
    }

    private fun getOutputFormat(formatType: String): SimpleDateFormat {
        return when (formatType) {
            FORMAT_FULL -> SimpleDateFormat("E, MMM dd 'AT' h:mm a", Locale.GERMANY)
            FORMAT_SHORT -> SimpleDateFormat("MMM dd, yyyy", Locale.GERMANY)
            // Add more format cases as needed
            else -> throw IllegalArgumentException("Invalid format type")
        }
    }
}
