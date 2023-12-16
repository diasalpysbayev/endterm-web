package kz.kbtu.webendterm.service.post;

import kz.kbtu.webendterm.entity.Post;
import kz.kbtu.webendterm.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  @Transactional
  public void create(Post post) {
    postRepository.save(post);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    postRepository.delete(postRepository.findById(id).orElseThrow());
  }

  @Override
  @Transactional
  public void edit(Post post) {
    Post oldPost = postRepository.findById(post.getId()).orElseThrow();
    postRepository.save(
        oldPost.setAuthor(post.getAuthor())
            .setText(post.getText())
            .setTitle(post.getTitle())
    );
  }

  @Override
  @Transactional(readOnly = true)
  public List<Post> getAll() {
    return postRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public List<Post> getAllByAuthor(String author) {
    return postRepository.findByAuthor(author);
  }
}
