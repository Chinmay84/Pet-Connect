package com.project.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.activation.FileTypeMap;
import javax.mail.internet.ContentType;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.beans.PostMetaData;
import com.project.dto.CreatePost;
import com.project.repository.PostCreationRepository;
import com.project.repository.PostFetchingRepository;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/unauthuser")
public class UploadController {

		@Autowired
		PostCreationRepository postCreationRepository;
		@Autowired
		PostFetchingRepository postFetchingRepository;
	    //Save the uploaded file to this folder
//	    private static String UPLOADED_FOLDER = "D:\\SpringJk\\BackendSpring-UpdatedCode\\BackendSpring\\src\\main\\resources\\Images\\";
		private static String UPLOADED_FOLDER = "D:\\Pet-Connect\\petproject\\public\\ServerImages\\";

	    @PostMapping("/upload") // //new annotation since 4.3
	    public String singleFileUpload(@RequestBody MultipartFile file,@RequestPart("user") String user ){
	    	
	    String name=null;
	    	
	        if (file.isEmpty()) {
	            return "error" ;
	        }
	        	System.out.println(user);
	        try {
	        
	            // Get the file and save it somewhere
	        	name=file.getOriginalFilename();//+"_"+UUID.randomUUID().toString();
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + name);
	           
	            Files.write(path, bytes);
	            CreatePost createpost = new CreatePost();
				PostMetaData userJson = getJson(user);
				createpost.setImagetext(userJson.getImagemessage());
				createpost.setName(file.getOriginalFilename());
				createpost.setPicByte(name);
				createpost.setType(file.getContentType());
				createpost.setUserName(userJson.getUserName());
				createpost.setCreatedDate(userJson.getCreatedDate());
				createpost.setUserEmail(userJson.getUserEmail());
				System.out.println(createpost);
				System.out.println(userJson);
				postCreationRepository.save(createpost);
	            return "done";
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	       

	        return "redirect:/uploadStatus";
	    }
/*	    
	    @GetMapping(value="/showimage",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)			
	    public String getImage() throws IOException{
	    	JSONArray jasonarray= new JSONArray();
	    	String imageName=null;
	    	File img=null;
	        List<CreatePost> allCreatedPost=postFetchingRepository.getallPost();
	    	for(int i=0;i<allCreatedPost.size();i++)
	    	{
	    		imageName=allCreatedPost.get(i).getPicByte();
	    		img = new File("D:\\SpringJk\\BackendSpring-UpdatedCode\\BackendSpring\\src\\main\\resources\\Images\\"+imageName);
	    		JSONObject jo = new JSONObject();
	      	  	jo.put("name", allCreatedPost.get(i).getName());
	      	  	jo.put("createddate",  allCreatedPost.get(i).getCreatedDate());
	      	  	jo.put("imagetext", allCreatedPost.get(i).getImagetext());
	      	  	jo.put("email", allCreatedPost.get(i).getUserEmail());
	      	  	jo.put("imgpath", allCreatedPost.get(i).getPicByte());
	      	  	jo.put("imgurl",img);
	      	  	jo.put("username", allCreatedPost.get(i).getUserName());
	      	  	jo.put("postid", allCreatedPost.get(i).getPostid());
	      	  	jo.put("imgtype", allCreatedPost.get(i).getType());
	      	  	jasonarray.put(jo);
	    		
	    	}
	         return jasonarray.toString();
	        //System.out.println("Image url:"+img+"Image name:"+imageName);
	     //   return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
	    }
	   
*/	    
	    
	    @GetMapping("/showimage")
	    public String getImage() throws IOException{
	    	JSONArray jasonarray= new JSONArray();
	    	String imageName=null;
	    	File img=null;
	        List<CreatePost> allCreatedPost=postFetchingRepository.getallPost();
	    	for(int i=0;i<allCreatedPost.size();i++)
	    	{
	    		imageName=allCreatedPost.get(i).getPicByte();
	    		img = new File("D:\\Pet-Connect\\petproject\\public\\ServerImages\\"+imageName);
	    		JSONObject jo = new JSONObject();
	      	  	jo.put("name", allCreatedPost.get(i).getName());
	      	  	jo.put("createddate",  allCreatedPost.get(i).getCreatedDate());
	      	  	jo.put("imagetext", allCreatedPost.get(i).getImagetext());
	      	  	jo.put("email", allCreatedPost.get(i).getUserEmail());
	      	  	jo.put("imgpath", allCreatedPost.get(i).getPicByte());
	      	  	jo.put("imgurl",img);
	      	  	jo.put("username", allCreatedPost.get(i).getUserName());
	      	  	jo.put("postid", allCreatedPost.get(i).getPostid());
	      	  	jo.put("imgtype", allCreatedPost.get(i).getType());
	      	  
	      	  	jasonarray.put(jo);
	    		
	    	}
	    	return jasonarray.toString();
	        // return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
	          
	        //System.out.println("Image url:"+img+"Image name:"+imageName);
	     //   return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
	    }
	  
	    
	    
	 /*   
	    @GetMapping("/showimage")
	    public ResponseEntity<byte[]> getImage() throws IOException{
	        File img = new File("D:\\SpringJk\\BackendSpring-UpdatedCode\\BackendSpring\\src\\main\\resources\\Images\\download.jpg");
	        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
	    }
	  */  
	    
	    
	    
	    public PostMetaData getJson(String user) {

			PostMetaData userJson = new PostMetaData();

			try {
				ObjectMapper objectMapper = new ObjectMapper();
				userJson = objectMapper.readValue(user, PostMetaData.class);
			} catch (IOException err) {
				System.out.printf("Error", err.toString());
			}

			return userJson;

		}
	    
	    
	    
	   
}
