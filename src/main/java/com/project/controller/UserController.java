package com.project.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.beans.Docter;
import com.project.beans.PostMetaData;
import com.project.beans.SecurityQuestion;
import com.project.beans.User;
import com.project.dto.CreatePost;
import com.project.dto.EditUser;
import com.project.dto.ForgotPassword;
import com.project.dto.SecurityQuestionData;
import com.project.message.MessageResponse;
import com.project.repository.DocterRepository;
import com.project.repository.PostCreationRepository;
import com.project.repository.PostFetchingRepository;
import com.project.repository.SearchByNameRepository;
import com.project.repository.UserRepository;
import com.project.service.UserCRUDService;
import com.project.service.UserService;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/unauthuser")
@RestController
public class UserController {

	@Autowired
	DocterRepository docterRepository; 
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SearchByNameRepository 	searchByNameRepository;

	@Autowired
	PostCreationRepository postCreationRepository;

	@Autowired
	UserCRUDService userCRUDService;
	
	@Autowired
	PostFetchingRepository postFetchingRepository;

	
/*	
	@PutMapping(value = "/edit", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> forEditUser(@RequestBody User user) {
		User u = userRepository.findUserforDelete(user.getEmail());
		System.out.println(user);
		if (u != null) {
			userCRUDService.updateUser(user);
			return ResponseEntity.ok("Updated Successfull");
		}
		return ResponseEntity.ok("not found");
		// return ResponseEntity.badRequest().body(new MessageResponse("Error : Username
		// not found!"));
	}
*/	
	
	@PutMapping(value = "/edit", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> forEdit(@RequestBody EditUser editUser) {
		User u = userRepository.findUserforDelete(editUser.getEmail());
		System.out.println(editUser);
		if (u != null) {
			userCRUDService.update(editUser);
			return ResponseEntity.ok("Updated Successfull");
		}
		return ResponseEntity.ok("not found");
		// return ResponseEntity.badRequest().body(new MessageResponse("Error : Username
		// not found!"));
	}
	
	
	
	
	@GetMapping(value = "/getuser/{email}")
	public User forGetOneUser(@PathVariable String email)
	{
		User user=userRepository.getUserforMailId(email);
		System.out.println(user);
		if(user!=null) {
			return user;
		}
		return null;
	}


/*	
	@GetMapping(value = "/getuser/{email}")
	public void forGetOneUser(@PathVariable String email)
	{
		List<Docter> user=docterRepository.findAll();
		System.out.println(user);
	
	}
*/	
	
	
	
	
	
	/*
	 * @PostMapping(value="/registerdoctor") public ResponseEntity<?>
	 * registerUser(@RequestBody SignUpRequest signUpRequest){ Optional<User>
	 * optUser=userRepository.findByEmail(signUpRequest.getEmail());
	 * if(optUser.isPresent()) { return ResponseEntity.badRequest().body(new
	 * MessageResponse("Error : Username is already taken!")); }
	 * userService.addUser(signUpRequest); return
	 * ResponseEntity.ok("user registered successfully"); }
	 */

	@DeleteMapping(value = "/delete/{email}", produces = "application/json")
	public ResponseEntity<?> forDeleteEmployee(@PathVariable("email") String email) {

		User user = userRepository.findUserforDelete(email);
		if (user != null) {
			userRepository.delete(user);
			return ResponseEntity.ok("Deleted Successfull");
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Error : Username not found!"));

	}
	
	@PostMapping(value = "/forgot/{email}")
	public ResponseEntity<?> forForgotPassword(@PathVariable("email") String email,@RequestBody SecurityQuestionData securityQuestionData) {

		User user = userRepository.findUserforDelete(email);
		
		if (user != null ) {
			int userid=user.getUserId();
			
			return ResponseEntity.ok("Updated");
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Error : Username not found!"));

	}
	
	
/*	
	@PostMapping(value = "/forgotpassword{email}")
	public String forPasswordResetValidation(@RequestBody SecurityQuestionData data,@PathVariable("email") String email)
	{
		userCRUDService.forgotPassword(email,data);
	}
*/	
	
	//API for creating the Post from Frontend...
	//It accept @RequestParam String user and Images files
	//{"userName": "Aadhi","userEmail" :"Sakthi","createdDate": "today","imagemessage":"testing for image content"}

	@RequestMapping(value = "/createpost", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE }, method = RequestMethod.POST)
	public String createNote(@RequestPart("user") String user, @RequestParam("imageFile") MultipartFile file) throws IOException {
		CreatePost createpost = new CreatePost();
		PostMetaData userJson = getJson(user);
		createpost.setImagetext(userJson.getImagemessage());
		createpost.setName(file.getOriginalFilename());
		//createpost.setPicByte(compressBytes(file.getBytes()));
		createpost.setType(file.getContentType());
		createpost.setUserName(userJson.getUserName());
		createpost.setCreatedDate(userJson.getCreatedDate());
		createpost.setUserEmail(userJson.getUserEmail());
		System.out.println(userJson);
		postCreationRepository.save(createpost);
		return "Sucessfully Save";
	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

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
	
	
	//API for getting all the post to display in the frontend post Scroll
	// get call the API in frontend you will get all the post data
	@RequestMapping(value="/getallpost", method=RequestMethod.GET)
	public List<CreatePost> fetchAllPost() {
      List<CreatePost> allCreatedPost=	postFetchingRepository.getallPost();
	return allCreatedPost;
	}
	
	
	@RequestMapping(value="/getdocterandfoster/{profession}", method=RequestMethod.GET)
	public List<User> getListOfUserByProfession(@PathVariable(value = "profession") String profession){
			List<User> listofUser=userRepository.getallDoctorAndFosterList(profession);
			return listofUser;
		
	}
	
	@RequestMapping(value="/forgotpassword", method=RequestMethod.POST)
	public String UpdateForgotPassword(@RequestBody ForgotPassword forgotPassword ) {
			
		User user=userRepository.getUserByMailId(forgotPassword.getEmail());
		try {
			if(user==null) {
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(!user.getAnswer().equals(forgotPassword.getAnswer()))
			{
			// throw incorrect passowrd
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	//	String emailid=user.getEmail();
		
		return userCRUDService.forgotPassword(forgotPassword);
	
	}
	
	//SearchByName
	@RequestMapping(value="/searchbyName", method=RequestMethod.GET)
	public List<User> searchByname(@PathVariable(value = "searchvalue") String searchKey){
			List<User> searchList=	searchByNameRepository.SearchUserName(searchKey);
			return searchList;
		
	}
	
	//SearchByAddress
	@RequestMapping(value="/notes", method=RequestMethod.GET)
	public List<User> searchByAddress(@PathVariable(value = "searchvalue") String searchKey){
			List<User> searchListAddress=	searchByNameRepository.SearchUserByAddress(searchKey);
			return searchListAddress;
		
	}
	
	
	

}
