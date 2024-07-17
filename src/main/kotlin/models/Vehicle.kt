package main.kotlin.models

import java.text.SimpleDateFormat
import java.util.Date

// Abstract class representing a general vehicle
abstract class Vehicle(
    val plateNumber: String, // License plate number of the vehicle
    val type: String,        // Type of the vehicle (Car, Bike, Truck)
    val entryTime: String,   // Time when the vehicle is parked in HH:MM format
    var exitTime: Long? = null // Time when the vehicle leaves
) {
    // Function to convert entry time to milliseconds for fee calculation
    private fun getEntryTimeInMillis(): Long {
        val sdf = SimpleDateFormat("HH:mm")
        val date: Date = sdf.parse(entryTime) ?: throw IllegalArgumentException("Format waktu tidak valid.")
        return date.time
    }

    // Abstract function to get vehicle information
    abstract fun getVehicleInfo(): String

    // Function to calculate parking fee based on the duration the vehicle is parked
    fun calculateParkingFee(): Double {
        val currentTime = exitTime ?: System.currentTimeMillis() // Use exitTime if available
        val duration = (currentTime - getEntryTimeInMillis()) / (1000.0 * 60.0 * 60.0) // Duration in hours as Double
        return when (type.toLowerCase()) {
            "car" -> 5000 * duration
            "bike" -> 2000 * duration
            "truck" -> 10000 * duration
            else -> 0.0
        }
    }
}
