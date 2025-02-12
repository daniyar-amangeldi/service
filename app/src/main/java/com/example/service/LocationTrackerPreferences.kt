package com.example.service

import android.location.Location

interface LocationTrackerPreferences {

    fun saveLocation(location: Location)

    fun getLocation(): Location
}