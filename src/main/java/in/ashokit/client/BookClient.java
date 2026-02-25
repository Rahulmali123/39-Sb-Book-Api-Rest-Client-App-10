package in.ashokit.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.binding.Book;

@Service
public class BookClient 
{
	public void invokeBookTicket() {
		String apiurl = "https://jsonplaceholder.typicode.com/posts/";

		Book book = new Book();

		book.setBookName("Java");
		book.setBookPrice(345.00);

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> postForEntity = rt.postForEntity(apiurl, book, String.class);

		System.out.println(postForEntity.getBody());

	}

	public void invokeGetBooksOld()
	{
		String apiurl = "https://jsonplaceholder.typicode.com/posts/";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> ForEntity = rt.getForEntity(apiurl, String.class);

		String body = ForEntity.getBody();
		
		System.out.println(body);
	}
	
	public void invokeGetBookNew()
	{
	    String apiurl = "https://jsonplaceholder.typicode.com/posts/";

	    RestTemplate rt = new RestTemplate();

	    ResponseEntity<Book[]> forEntity = rt.getForEntity(apiurl, Book[].class);

	    Book[] body = forEntity.getBody();

	    for (Book book : body)
	    {
	        System.out.println(book);
	    }
	}
}
