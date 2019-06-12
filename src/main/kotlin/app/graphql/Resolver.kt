package app.graphql

import app.dao.AuthorDao
import app.dao.PostDao
import app.dto.Author
import app.dto.Post
import app.repository.EventRepository
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.beans.factory.annotation.Autowired

class PostResolver(private val authorDao: AuthorDao) : GraphQLResolver<Post> {

    fun getAuthor(post: Post): Author? = authorDao.getAuthor(post.authorId!!)
}

class AuthorResolver(private val postDao: PostDao) : GraphQLResolver<Author> {

    fun getPosts(author: Author): List<Post> = postDao.getAuthorPosts(author.id!!)
}

//class EventResolver(private val eventDao: EventDao) : GraphQLResolver<Event> {
//
//    fun getEvents(): List<Event> = eventDao.fetch()
//}

//class EventResolver(private val eventRepository: EventRepository) : GraphQLResolver<app.entity.Event> {
class EventResolver : GraphQLResolver<app.entity.Event> {

    @Autowired
    private lateinit var eventRepository: EventRepository

    fun getEvents(): Iterable<app.entity.Event> = eventRepository.findAll()
}