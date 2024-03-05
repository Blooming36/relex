package com.javatechie.service;

import com.javatechie.entity.EmployeeRating;
import com.javatechie.entity.UserInfo;
import com.javatechie.repository.EmployeeRatingRepository;
import com.javatechie.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeRatingService {
    @Autowired
    private EmployeeRatingRepository repository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    public String addRatingUser(int id, int rating){
        UserInfo userInfo = userInfoRepository.findById(id);
        EmployeeRating employeeRating = new EmployeeRating(rating,new Date(),userInfo);
        repository.save(employeeRating);
        return "Пользователю c именем " + userInfo.getFirstName() + " " + userInfo.getLastName()
                + " добавлен рейтинг " + employeeRating.getRating();
    }
    public String checkRating(int id){
        EmployeeRating employeeRating = repository.findByUserInfoIdAndDate(id,new Date());
        return "Вы сегодня получили оценку " + employeeRating.getRating();
    }
}
