package app.graphql

import app.dao.PostDao
import app.dto.Post
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired


//class Query(private val postDao: PostDao, private val eventDao: EventDao) : GraphQLQueryResolver {
class Query(private val postDao: PostDao) : GraphQLQueryResolver {

    @Autowired
    private lateinit var eventResolver: EventResolver

    fun getRecentPosts(count: Int, offset: Int): List<Post> = postDao.getRecentPosts(count, offset)

    fun getEvents(): Iterable<app.entity.Event> = eventResolver.getEvents()
}
