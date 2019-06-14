package app.graphql.mutation

import app.dto.Event
import app.service.EventService
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class EventMutation(val eventService: EventService) : GraphQLMutationResolver {

    fun postEvent(name: String): Event {

        val dto = Event(id = null, name = name)
        eventService.save(name)
        return dto
    }
}