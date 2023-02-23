package com.movieHam.movie.service.movie;

import org.apache.commons.text.CaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import util.StringHandler;
import util.com.CommonUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> search(String group, String groupKeyword, String order, String orderType,
                              Integer pageIndex, Integer countPerPage) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String groupFirstUpper = StringHandler.firstLetterUpperCase(group);
        String groupKeywordFirstUpper = StringHandler.firstLetterUpperCase(CommonUtil.checkNullEmpty(groupKeyword, ""));

        Class repositoryBean = movieRepository.getClass();
        Method m;

        String methodName = "";
        if("All".equals(groupFirstUpper)){
            methodName = "findAll";
            m = repositoryBean.getMethod(methodName, Pageable.class);
        }else{
            methodName = "findBy" + groupFirstUpper + "Contains";
            m = repositoryBean.getMethod(methodName, String.class, Pageable.class);
        }


        Sort sort = Sort.by(order);

        PageRequest pageRequest = PageRequest.of(CommonUtil.checkNullEmpty(pageIndex, 0), CommonUtil.checkNullEmpty(countPerPage, 100), "asc".equals(orderType)?sort.ascending():sort.descending());

        List<Movie> resultList = (List<Movie>) m.invoke(movieRepository, groupKeywordFirstUpper, pageRequest);

        return resultList;
    }

    public void saveAll(List<Movie> movieBeanList) {
        movieRepository.saveAll(movieBeanList);
        movieRepository.flush();
    }
}
