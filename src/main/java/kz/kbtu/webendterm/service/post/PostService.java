package kz.kbtu.webendterm.service.post;

import kz.kbtu.webendterm.entity.Post;

import java.util.List;

public interface PostService {

  void create(Post post);

  void delete(Long id);

  void edit(Post post);

  List<Post> getAll();

  List<Post> getAllByAuthor(String author);
}
