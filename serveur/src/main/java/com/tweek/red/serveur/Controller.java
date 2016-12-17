package com.tweek.red.serveur;

import com.tweek.red.commun.Personne;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tweek on 16/12/16.
 */
@RestController
public class Controller {
    @RequestMapping("/")
    public List<Personne> helloWorld(){
        List<Personne> liste=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            liste.add(new Personne("anonymous"+i,"anonymous"+i,i));

        }
        return liste;
    }
}
