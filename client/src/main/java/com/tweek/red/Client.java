package com.tweek.red;

import com.tweek.red.commun.Personne;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by tweek on 17/12/16.
 */
public class Client {
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        ParameterizedTypeReference<List<Personne>> myBean = new ParameterizedTypeReference<List<Personne>>() {};
        ResponseEntity<List<Personne>> response = template.exchange("http://localhost:8080", HttpMethod.GET, null, myBean);
        response.getBody().forEach(p -> System.out.println("personne recuperee" + p));

    }
}
