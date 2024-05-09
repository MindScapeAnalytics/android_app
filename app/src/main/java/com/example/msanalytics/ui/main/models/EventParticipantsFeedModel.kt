package com.example.msanalytics.ui.main.models

class EventParticipantsFeedModel constructor(
    val image: Array<Byte>? = null,
    val text: String = "",
    val type: Int? = null
) {
    val FIRST_TYPE: Int = 0
    val SECOND_TYPE: Int = 1
}

