package app.service

import app.repository.EventRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import app.dto.Event as EventDTO
import app.entity.Event as EventEntity

@Service
class EventService(private val eventRepository: EventRepository) {

    fun findAll(): Collection<EventDTO> {
        val entities = eventRepository.findAll()
        return map(entities)

    }

    fun findById(id: UUID): EventDTO? {
        val entity = eventRepository.findByIdOrNull(id)
        return if (entity != null) map(entity) else null
    }

    fun save(name: String) {
        val entity = EventEntity(name = name)
        eventRepository.save(entity)
    }

    companion object {
        fun map(entity: EventEntity): EventDTO = EventDTO(
                id = entity.id,
                name = entity.name
        )

        fun map(entities: Iterable<EventEntity>): Collection<EventDTO> = entities.map { e -> map(e) }
    }
}