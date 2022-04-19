package com.movieHam.movie;

import com.api.ApiConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MovieController {

    @GetMapping(value="/movie/list", produces = "application/json; charset=UTF-8")
    public String list(){

        ApiConnection con = new ApiConnection();
        try {

            Map<String,Object> resultMap = con.kobisMoviList();
            String st = resultMap.toString();

            return st;
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value="/movie/{type}", produces = "application/json; charset=UTF-8")
    public String search(@PathVariable String title){

        ApiConnection con = new ApiConnection();
        try {

//            Map<String,Object> resultMap = con.kmdbMovieSearch();
//            String st = resultMap.toString();

//            return st;
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value="/movie/init")
    public String init() {



        return "success!";
    }
}
