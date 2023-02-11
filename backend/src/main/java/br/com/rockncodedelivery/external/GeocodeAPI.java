//package br.com.rockncodedelivery.external;
//
//import br.com.rockncodedelivery.external.dto.ResponseGeocodeApi;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriBuilderFactory;
//
//public class GeocodeAPI {
//
//    private final RestTemplate restTemplate;
//
//    public GeocodeAPI(final RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public ResponseGeocodeApi requestToGeocodeApi(String adress) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        //        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
////        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//        restTemplate.getForEntity();
//
//
//        return null;
//    }
//}
//
////        HttpHeaders httpHeaders = new HttpHeaders();
////        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
////        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
////
////
////        HttpEntity<PixRequestDTO> httpEntity = new HttpEntity<PixRequestDTO>(json, httpHeaders);
////        RestTemplate restTemplate = new RestTemplate();
////
////        String URL = urlIntegracaoBase.concat();
////
////        return restTemplate.exchange(URL, POST, httpEntity, PixResponseDTO.class).getBody();