package rescueme

data class Location(val lat : Int, val long: Int)

interface GeoLocator {
    fun currentLocation(): Location
    fun distance(from: Location, to: Location): Int
}

interface SmsGateway {
    fun sendText(phoneNumber: String)
}