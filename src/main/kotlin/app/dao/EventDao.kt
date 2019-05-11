package app.dao

import app.dto.Event
import java.util.*

class EventDao(private val events: MutableList<Event>) {

    fun fetch(): List<Event> = events

    fun fetchById(id: UUID): Event? = events.firstOrNull { event -> id == event.id }

    fun store(name: String) = events.add(Event(UUID.randomUUID(), name))

    fun store(id: UUID, name: String) = events.add(Event(id, name))
}