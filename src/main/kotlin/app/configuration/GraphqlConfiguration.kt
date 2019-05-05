package app.configuration

import app.graphql.Mutation
import app.dao.PostDao
import app.graphql.AuthorResolver
import app.graphql.PostResolver
import app.dao.AuthorDao
import app.dto.Author
import java.util.ArrayList
import app.dto.Post
import app.graphql.Query
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


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
    fun postResolver(authorDao: AuthorDao): PostResolver {
        return PostResolver(authorDao)
    }

    @Bean
    fun authorResolver(postDao: PostDao): AuthorResolver {
        return AuthorResolver(postDao)
    }

    @Bean
    fun query(postDao: PostDao): Query {
        return Query(postDao)
    }

    @Bean
    fun mutation(postDao: PostDao): Mutation {
        return Mutation(postDao)
    }
}