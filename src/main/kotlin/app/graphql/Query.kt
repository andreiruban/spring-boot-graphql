package app.graphql

import app.dao.EventDao
import app.dao.PostDao
import app.dto.Event
import app.dto.Post
import com.coxautodev.graphql.tools.GraphQLQueryResolver


class Query(private val postDao: PostDao, private val eventDao: EventDao) : GraphQLQueryResolver {

    fun getRecentPosts(count: Int, offset: Int): List<Post> = postDao.getRecentPosts(count, offset)

    fun getEvents(): List<Event> = eventDao.fetch()
}
