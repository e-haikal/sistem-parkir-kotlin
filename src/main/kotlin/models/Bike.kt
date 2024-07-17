package main.kotlin.models

// Class representing a Bike
class Bike(plateNumber: String, entryTime: String) : Vehicle(plateNumber, "Bike", entryTime) {
    override fun getVehicleInfo(): String {
        return "Sepeda motor dengan plat $plateNumber"
    }
}
