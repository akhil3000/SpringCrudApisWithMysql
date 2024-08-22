package com.example.demo.service.impl;
import com.example.demo.entity.Post;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.PostDto;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private PostRepository postRepository;

    @Override
   public PostDto createPost(PostDto postDto){

        //Post post=new Post();//Created Post Object
        //post.setTitle(postDto.getTitle());//RequestBody is Passed into DTO class
        //post.setDescription(postDto.getDescription());//Getting Data from DTO class
        //post.setContent(postDto.getContent());
        //Post newPost=postRepository.save(post);//Sending Post object to Database repo
        //Retrieving data from Databae using PostResponse Class
        //PostDto postResponse=new PostDto();
        //postResponse.setId(newPost.getId());
        //postResponse.setTitle(newPost.getTitle());
        //postResponse.setDescription(newPost.getDescription());
        //postResponse.setContent(newPost.getContent());
        Post post=mapToEntity(postDto);
        Post newPost=postRepository.save(post);


        PostDto postResponse=mapToDTO(newPost);

        return postResponse;


    }
    @Override
    public List<PostDto> getAllPosts(){
      List<Post>posts=postRepository.findAll();
      return posts.stream().map(post->mapToDTO(post)).collect(Collectors.toList());


    }

    @Override
    public PostDto getPostById(long id){
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        return mapToDTO(post);

    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //get post by id from the database
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        //Updating values of specified Object from the data taken from Request Body class PostDto
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost=postRepository.save(post);
        return mapToDTO(updatedPost);

    }

    @Override
    public void deletePost(long id) {
        //getting post id from the database
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        postRepository.delete(post);
    }


    //Mapping from Entity to DTO i.e Retrieving data from database Model
    private PostDto mapToDTO(Post post){
        PostDto postDto=new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;

    }
    //Retrieving data from Request Object
    private Post mapToEntity(PostDto postDto)
    {

        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;

    }



}
