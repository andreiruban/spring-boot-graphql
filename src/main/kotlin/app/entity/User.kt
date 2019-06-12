package app.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Table(name = "users")
@Entity
class User {

    @Id
    @GeneratedValue
    var id: Int = 0

    var firstName: String? = null

    var lastName: String? = null

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\''.toString() +
                ", lastName='" + lastName + '\''.toString() +
                '}'.toString()
    }
}