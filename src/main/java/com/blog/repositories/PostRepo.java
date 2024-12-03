package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

	// internally uses '%like' to find out the items from database.
	List<Post> findByTitleContaining(String title);

	List<Post> findByContentContaining(String content);
	// if we want to search post according to keywords in 'content'.
//	List<Post> findByContentContaining(String content);

	
//	@Query("select p from Post p where p.title like :key")
//	List<Post> searchByTitle(@Param("key") String title);
}
