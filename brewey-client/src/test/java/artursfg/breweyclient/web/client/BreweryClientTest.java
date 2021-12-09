package artursfg.breweyclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import artursfg.breweyclient.web.model.BeerDto;
import artursfg.breweyclient.web.model.CustomerDto;
import java.net.URI;
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
    BeerDto dto = client.getBeerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void savedNewBeer() {
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
    URI  uri = client.saveNewBeer(beerDto);
    assertNotNull(uri);
    System.out.println(uri.toString());
  }
  @Test
  void updateBeer(){
    BeerDto beerDto=BeerDto.builder().beerName("New Beer").build();
    client.updateBeer(beerDto, UUID.randomUUID());
  }
  @Test
  void deleteBeer(){
    client.deleteBeer(UUID.randomUUID());
  }
  @Test
  void getCustomerById(){
    CustomerDto dto= client.getCustomerById(UUID.randomUUID());
    assertNotNull(dto);
  }
  @Test
  void saveNewCustomer(){
    CustomerDto customerDto= CustomerDto.builder().name("Toquio").build();
    URI uri=client.saveNewCustomer(customerDto);
    assertNotNull(uri);
    System.out.println(uri.toString());
  }
  @Test
  void updateCustomer(){
    CustomerDto customerDto=CustomerDto.builder().name("toquio").build();
    client.updateCustomer(UUID.randomUUID(),customerDto);
  }
  @Test
  void deleteCustomer(){
    client.deleteCustomer(UUID.randomUUID());
  }
}