package controller;

import com.alkemy.ong.controller.NewsController;
import com.alkemy.ong.models.request.NewsRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NewsControllerTest {

    NewsController controller = new NewsController();

    @Test
    public void when_idIsNotFound_then_ResponseNotFound(){
        


        Long id = Long.MAX_VALUE;

        Assertions.assertEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null), controller.read(id));
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null), controller.delete(id));
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null), controller.update(id, new NewsRequest()));
    }

    @Test
    public void when_notAuthenticatedAndTryingToAccessToSecuredEndpoints_then_responseForbidden(){



    }

    @Test
    public void when_notAuthorizedAsAdminAndTryingToAccessToOnlyAdminEndpoints_then_responseUnauthorized(){

    }

    @Test
    public void when_newsRequestsNameIsNull_then_responseBadRequest(){

        NewsRequest newsRequest = new NewsRequest();
        newsRequest.setName(null);
        newsRequest.setContent("Lorem Ipsum...");
        newsRequest.setImage("news.jpg");
        newsRequest.setCategoryId(Long.valueOf(1));

        Assertions.assertEquals(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null), controller.create(newsRequest));
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null), controller.update(Long.valueOf(1), newsRequest));
    }
    @Test
    public void when_newsRequestsContentIsNull_then_responseBadRequest(){

        NewsRequest newsRequest = new NewsRequest();
        newsRequest.setName("News");
        newsRequest.setContent(null);
        newsRequest.setImage("news.jpg");
        newsRequest.setCategoryId(Long.valueOf(1));

        Assertions.assertEquals(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null), controller.create(newsRequest));
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null), controller.update(Long.valueOf(1), newsRequest));
    }
    @Test
    public void when_newsRequestsImageIsNull_then_responseBadRequest(){

        NewsRequest newsRequest = new NewsRequest();
        newsRequest.setName("News");
        newsRequest.setContent("Lorem Ipsum...");
        newsRequest.setImage(null);
        newsRequest.setCategoryId(Long.valueOf(1));

        Assertions.assertEquals(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null), controller.create(newsRequest));
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null), controller.update(Long.valueOf(1), newsRequest));
    }
    @Test
    public void when_newsRequestsCategoryIdIsNull_then_responseBadRequest(){

        NewsRequest newsRequest = new NewsRequest();
        newsRequest.setName("News");
        newsRequest.setContent("Lorem Ipsum...");
        newsRequest.setImage("news.jpg");
        newsRequest.setCategoryId(null);

        Assertions.assertEquals(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null), controller.create(newsRequest));
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null), controller.update(Long.valueOf(1), newsRequest));
    }
}