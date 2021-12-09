package artursfg.breweyclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import artursfg.breweyclient.web.model.BeerDto;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreweryClientTest {

@Autowired
BreweryClient client;

  @Test
  void getBeerById() {
    BeerDto dto= client.getBeerById(UUID.randomUUID());
    assertNotNull(dto);
  }
}