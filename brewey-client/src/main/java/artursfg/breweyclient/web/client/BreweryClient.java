package artursfg.breweyclient.web.client;

import artursfg.breweyclient.web.model.BeerDto;
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
  private String apihost;
  private final RestTemplate restTemplate;

  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDto getBeerById(UUID id) {
    return restTemplate.getForObject(apihost + BEER_PATH_V1 + id.toString(), BeerDto.class);
  }


}
