package app.graphql

import app.dao.AuthorDao
import app.dao.EventDao
import app.dao.PostDao
import app.dto.Author
import app.dto.Event
import app.dto.Post
import com.coxautodev.graphql.tools.GraphQLResolver

class PostResolver(private val authorDao: AuthorDao) : GraphQLResolver<Post> {

    fun getAuthor(post: Post): Author? = authorDao.getAuthor(post.authorId!!)
}

class AuthorResolver(private val postDao: PostDao) : GraphQLResolver<Author> {

    fun getPosts(author: Author): List<Post> = postDao.getAuthorPosts(author.id!!)
}

class EventResolver(private val eventDao: EventDao) : GraphQLResolver<Event> {

    fun getEvents(): List<Event> = eventDao.fetch()
}