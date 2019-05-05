package app.dao

import app.dto.Post


class PostDao(private val posts: MutableList<Post>) {

    fun getRecentPosts(count: Int, offset: Int): List<Post> = posts.drop(offset).take(count)

    fun getAuthorPosts(author: String): List<Post> = posts.filter { post -> author == post.authorId }

    fun savePost(post: Post) {
        posts.add(0, post)
    }
}