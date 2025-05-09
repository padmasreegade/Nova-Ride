package com.example.novaride

import android.content.Context
import android.location.Location
import fi.iki.elonen.NanoHTTPD

class LocationServer(private val context: Context) : NanoHTTPD(8081) {

    private var lastKnownLocation: Location? = null

    fun updateLocation(location: Location) {
        lastKnownLocation = location
    }

    override fun serve(session: IHTTPSession): Response {
        return if (lastKnownLocation != null) {
            val json = """
                {
                    "latitude": ${lastKnownLocation!!.latitude},
                    "longitude": ${lastKnownLocation!!.longitude}
                }
            """.trimIndent()
            newFixedLengthResponse(Response.Status.OK, "application/json", json)
        } else {
            newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "Location not available")
        }
    }
}
