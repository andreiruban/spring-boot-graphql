package app.graphql.query

import app.dto.Event
import app.service.EventService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class EventQuery(val eventService: EventService) : GraphQLQueryResolver {

    fun getEvents(): Collection<Event> = eventService.findAll()
}