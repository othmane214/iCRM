package com.tweek.red.serveur;

import com.tweek.red.commun.Personne;
import com.tweek.red.dao.PersonneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by tweek on 16/12/16.
 */
@RestController
public class Controller {

    @Autowired
    private PersonneDao personneDao;

    @RequestMapping("/")
    public List<Personne> helloWorld(){
        List<Personne> liste = personneDao.getAll();
        return liste;
    }
}
