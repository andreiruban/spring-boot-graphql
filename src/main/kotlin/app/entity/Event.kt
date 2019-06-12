package app.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "event")
data class Event(

        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid")
        @Column(name = "e_id", updatable = false, nullable = false)
        private val id: String = "",

        @Column(name = "e_name", updatable = true, nullable = false)
        private val name: String
)