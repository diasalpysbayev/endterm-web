package kz.kbtu.webendterm.repository;

import kz.kbtu.webendterm.entity.Post;
import kz.kbtu.webendterm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findByAuthor(String author);
}