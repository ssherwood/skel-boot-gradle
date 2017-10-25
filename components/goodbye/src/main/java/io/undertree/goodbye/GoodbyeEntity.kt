package io.undertree.goodbye

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "GOODBYE")
class GoodbyeEntity(
        @Id
        @GeneratedValue
        val id: Long? = -1,
        var name: String? = null) {

    //

    companion object {
        fun placeHolder() = 42
    }
}