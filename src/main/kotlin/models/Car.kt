package main.kotlin.models

// Class representing a Car
class Car(plateNumber: String, entryTime: String) : Vehicle(plateNumber, "Car", entryTime) {
    override fun getVehicleInfo(): String {
        return "Mobil dengan plat $plateNumber"
    }
}
