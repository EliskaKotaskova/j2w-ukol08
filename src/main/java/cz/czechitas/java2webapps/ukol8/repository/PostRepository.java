package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

 @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {

     Post findBySlug(@Param("slug") String slug);

     @Query("SELECT p FROM Post p WHERE p.published IS NOT NULL AND p.published <= CURRENT_DATE ORDER BY p.published DESC")
     Page<Post> findPublishedPosts(Pageable postList);
}
