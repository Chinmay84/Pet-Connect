package com.project.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dto.CreatePost;
import com.project.repository.PostFetchingRepository;
import com.project.repository.UserRepository;

public class PostsServiceImpl implements PostsService{

	@Autowired
	PostFetchingRepository postFetchingRepository;
	
	@Autowired
	UserRepository userRepository;
	
/*
	@Override
	public ImageIO byteToImageConverter() throws IOException {
		BufferedImage buffered_image= ImageIO.read(new File("myfile.jpg"));
	    ByteArrayOutputStream output_stream= new ByteArrayOutputStream();
	    ImageIO.write(buffered_image, "jpg", output_stream);	
		
		
	    byte [] byte_array = postFetchingRepository.                        /*output_stream.toByteArray(); 
	    ByteArrayInputStream input_stream= new ByteArrayInputStream(byte_array);
	    BufferedImage final_buffered_image = ImageIO.read(input_stream);
	    ImageIO.write(final_buffered_image , "jpg", new File("final_file.jpg") );
	    System.out.println("Converted Successfully!");
		return null;
	}
	*/

}
