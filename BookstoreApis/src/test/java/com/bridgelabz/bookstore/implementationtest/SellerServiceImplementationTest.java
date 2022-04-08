package com.bridgelabz.bookstore.implementationtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bridgelabz.bookstore.controller.SellerController;
import com.bridgelabz.bookstore.dto.RegisterDto;
import com.bridgelabz.bookstore.entity.Seller;
import com.bridgelabz.bookstore.response.Response;
import com.bridgelabz.bookstore.service.SellerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.boolex.Matcher;

//@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(SellerController.class)
public class SellerServiceImplementationTest {
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testSellerRegister() throws Exception 
	{
	  mvc.perform( MockMvcRequestBuilders
	      .post("/registration")
	      .content(asJsonString(new RegisterDto("csandhyait@gmail.com","sandy","sandy",9955737799L)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isCreated())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
	}
	 
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
	
//	
//	@Autowired
//	private WebApplicationContext context;
//	@Before
//	public void setup() {
//		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();			
//	}		
//	
//	
	
	@Mock
	SellerService sellerServiceImpl;
	@InjectMocks
	SellerController controller;
	ObjectMapper ob=new ObjectMapper();
//
//	String token = null;

//	@Test
//	public void registerSeller() throws Exception {
//		Seller seller=new Seller();
//		RegisterDto sellerDto= new RegisterDto();
//		sellerDto.setEmail("csandhyait@gmail.com");
//		sellerDto.setName("sandy");
//		sellerDto.setPassword("sandy");
//		sellerDto.setMobileNumber(8087968370L);
//		String json=ob.writeValueAsString(sellerDto);		
//		Mockito.when(sellerServiceImpl.register(sellerDto)).thenReturn(seller);
//		mvc.perform(post("/seller/registration").content(json).content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
//				.andExpect(jsonPath("$.email", Matchers.is("csandhyait@gmail.com")))
//				.andExpect(jsonPath("$.password", Matchers.is("$2a$10$SdQk7Hze6Io7N6sPIH5nHeoeccoGNdcD8IbkpUO9.JkEK0IrxX7fy")))
//				.andExpect(jsonPath("$.mobileNumber", Matchers.is(8087968370L)))
//				.andExpect(jsonPath("$.sellerId", Matchers.is(1L)))
//				.andExpect(jsonPath("$.isVerified", Matchers.is("false")))
//				.andExpect(jsonPath("$.profile", Matchers.is("null")))				
//				.andExpect(jsonPath("$.name", Matchers.is("sandy")));
//		//String resultContent=result.getResponse().getContentAsString();	
//         assertThat(seller).isNotNull(); 
//	}
//
//	@Test
//	public void testLogin() throws Exception {
//		Seller seller = new Seller();
//		LoginDto login = new LoginDto();
//		login.setEmail("csandhyait@gmail.com");
//		login.setPassword("sandy");
//		Mockito.when(sellerServiceImpl.login(login)).thenReturn(seller);
//		assertThat(seller).isNotNull();
//	}
//
//	@Test
//	public void testVerify() {
//		Seller seller = new Seller();
//		seller.setSellerId(3L);
//		Mockito.when(JwtService.generateToken(3L, Token.WITH_EXPIRE_TIME)).thenReturn(token);
//		Mockito.when(sellerServiceImpl.verify(
//				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6M30.J7bbcxYxFXsWCWRY3DMIuSAFZ_PwgmvlOShtZh5ew2UEOFwiSnfIyon0sUYuZx5RO1VVwHvFFOhEfl5a-daIOA"))
//				.thenReturn(true);
//		assertThat(token).isNotNull();
//	}
//
//	@Test
//	public void testForgetPassword() {
//		Seller seller = new Seller();
//		seller.setEmail("csandhyait@gmail.com");
//		Mockito.when(sellerServiceImpl.forgetPassword("csandhyait@gmail.com")).thenReturn(seller);
//		assertThat(seller).isNotNull();
//	}
//
//	@Test
//	public void testResetPassword() {
//		Seller seller = new Seller();
//		seller.setSellerId(3L);
//		ResetPassword password = new ResetPassword();
//		password.setConfirmPassword("sandhya");
//		Mockito.when(sellerServiceImpl.resetPassword(password,
//				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6M30.J7bbcxYxFXsWCWRY3DMIuSAFZ_PwgmvlOShtZh5ew2UEOFwiSnfIyon0sUYuZx5RO1VVwHvFFOhEfl5a-daIOA"))
//				.thenReturn(true);
//		assertThat(seller).isNotNull();
//	}
//
//	@Test
//	public void testGetSellerById() {
//		Seller seller = new Seller();
//		seller.setSellerId(3L);
//		Mockito.when(sellerServiceImpl.getSellerById(
//				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6M30.J7bbcxYxFXsWCWRY3DMIuSAFZ_PwgmvlOShtZh5ew2UEOFwiSnfIyon0sUYuZx5RO1VVwHvFFOhEfl5a-daIOA"))
//				.thenReturn(seller);
//		assertThat(seller).isNotNull();
//	}
//
//	@Test
//	public void testGetBooks() {
//		Seller seller = new Seller();
//		seller.setSellerId(3L);
//		List<Book> book = seller.getSellerBooks();
//		Mockito.when(sellerServiceImpl.getBooks(
//				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6M30.J7bbcxYxFXsWCWRY3DMIuSAFZ_PwgmvlOShtZh5ew2UEOFwiSnfIyon0sUYuZx5RO1VVwHvFFOhEfl5a-daIOA"))
//				.thenReturn(book);
//		assertThat(book).isNotNull();
//	}
}
