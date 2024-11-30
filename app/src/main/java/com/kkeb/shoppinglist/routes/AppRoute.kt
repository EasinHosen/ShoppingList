package com.kkeb.shoppinglist.routes

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute
@Serializable
object AddEventRoute
@Serializable
data class EventDetailRoute(val id: Long, val name: String)