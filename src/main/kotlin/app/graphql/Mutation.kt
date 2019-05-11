package app.graphql

import app.dao.EventDao
import app.dao.PostDao
import app.dto.Event
import app.dto.Post
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import java.util.UUID

class Mutation(private val postDao: PostDao, private val eventDao: EventDao) : GraphQLMutationResolver {

    fun writePost(title: String, text: String, category: String, author: String): Post {
        val post = Post()
        post.id = UUID.randomUUID().toString()
        post.title = title
        post.text = text
        post.category = category
        post.authorId = author
        postDao.savePost(post)

        return post
    }

    fun postEvent(name: String): Event {
        val event = Event(UUID.randomUUID(), name)
        eventDao.store(event.id ,event.name)
        return event
    }
}