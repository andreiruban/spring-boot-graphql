package app.repository

import app.entity.Event
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface EventRepository : CrudRepository<Event, UUID>
