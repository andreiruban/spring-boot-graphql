package app.configuration

import app.dao.AuthorDao
import app.dao.EventDao
import app.dao.PostDao
import app.dto.Author
import app.dto.Event
import app.dto.Post
import app.graphql.AuthorResolver
import app.graphql.EventResolver
import app.graphql.Mutation
import app.graphql.PostResolver
import app.graphql.Query
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.UUID
import kotlin.collections.ArrayList


@Configuration
class GraphqlConfiguration {

    @Bean
    fun postDao(): PostDao {
        val posts = ArrayList<Post>()
        for (postId in 0..9) {
            for (authorId in 0..9) {
                val post = Post()
                post.id = "Post$authorId$postId"
                post.title = "Post $authorId:$postId"
                post.text = "Post $postId + by author $authorId"
                post.authorId = "Author$authorId"
                posts.add(post)
            }
        }
        return PostDao(posts)
    }

    @Bean
    fun authorDao(): AuthorDao {
        val authors = ArrayList<Author>()
        for (authorId in 0..9) {
            val author = Author()
            author.id = "Author$authorId"
            author.name = "Author $authorId"
            author.thumbnail = "http://example.com/authors/$authorId"
            authors.add(author)
        }
        return AuthorDao(authors)
    }

    @Bean
    fun eventDao(): EventDao {
        val events = ArrayList<Event>()
        for (eventId in 0..9) {
            events.add(Event(UUID.randomUUID(), name = "Event $eventId"))
        }
        return EventDao(events)
    }

    @Bean
    fun postResolver(authorDao: AuthorDao): PostResolver = PostResolver(authorDao)

    @Bean
    fun authorResolver(postDao: PostDao): AuthorResolver = AuthorResolver(postDao)

    @Bean
    fun eventResolver(eventDao: EventDao): EventResolver = EventResolver(eventDao)

    @Bean
    fun query(postDao: PostDao, eventDao: EventDao): Query = Query(postDao, eventDao)

    @Bean
    fun mutation(postDao: PostDao, eventDao: EventDao): Mutation = Mutation(postDao, eventDao)
}