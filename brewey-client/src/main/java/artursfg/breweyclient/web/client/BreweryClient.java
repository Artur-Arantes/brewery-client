package artursfg.breweyclient.web.client;

import artursfg.breweyclient.web.model.BeerDto;
import artursfg.breweyclient.web.model.CustomerDto;
import java.net.URI;
import java.util.UUID;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Setter
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
  public final String BEER_PATH_V1 = "/api/v1/beer/";
  public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
  private String apihost;
  private final RestTemplate restTemplate;

  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDto getBeerById(UUID id) {
    return restTemplate.getForObject(apihost + BEER_PATH_V1 + id.toString(), BeerDto.class);
  }

  public URI saveNewBeer(BeerDto dto) {
    return restTemplate.postForLocation(apihost + BEER_PATH_V1, dto);
  }

  public void updateBeer(BeerDto beerDto, UUID id) {
    restTemplate.put(apihost + BEER_PATH_V1 + "/" + id.toString(), beerDto);
  }

  public void deleteBeer(UUID id) {
    restTemplate.delete(apihost + BEER_PATH_V1 + "/" + id.toString());
  }

  public CustomerDto getCustomerById(UUID randomUUID) {
    return restTemplate.getForObject(apihost+CUSTOMER_PATH_V1+randomUUID.toString(),CustomerDto.class);
  }

  public URI saveNewCustomer(CustomerDto customerDto) {
    return restTemplate.postForLocation(apihost+BEER_PATH_V1,customerDto);
  }

  public void deleteCustomer(UUID randomUUID) {
    restTemplate.delete(apihost+CUSTOMER_PATH_V1+randomUUID);
  }

  public void updateCustomer(UUID randomUUID, CustomerDto customerDto) {
    restTemplate.put(apihost+CUSTOMER_PATH_V1+"/"+randomUUID.toString(),customerDto);
  }
}
