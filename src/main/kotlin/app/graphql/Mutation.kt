package app.graphql

import app.dao.PostDao
import app.dto.Post
import app.repository.EventRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

//class Mutation(private val postDao: PostDao, private val eventDao: EventDao) : GraphQLMutationResolver {
class Mutation(private val postDao: PostDao) : GraphQLMutationResolver {

    @Autowired
    private lateinit var eventRepository: EventRepository

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

//    fun postEvent(name: String): Event {
    fun postEvent(name: String): app.entity.Event {
//        val event = Event(UUID.randomUUID(), name)
        val event = app.entity.Event(name = name)

        eventRepository.save(event)
        return event
    }
}