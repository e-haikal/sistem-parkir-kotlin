package main.kotlin.models

// Class representing a Truck
class Truck(plateNumber: String, entryTime: String) : Vehicle(plateNumber, "Truck", entryTime) {
    override fun getVehicleInfo(): String {
        return "Truk dengan plat $plateNumber"
    }
}
