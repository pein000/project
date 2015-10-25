package com.one.shop.service;

import com.one.shop.domain.Car;
import com.one.shop.domain.FullCar;
import com.one.shop.entity.CarEntity;
import com.one.shop.repository.CarRepository;
import com.one.shop.repository.impl.CarRepositoryImpl;
import com.one.shop.util.ShopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pein on 2015/10/21.
 */
@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarRepositoryImpl carRepositoryImpl;

    /**
     * 查询购物车记录的全属性
     * @param userId
     * @return
     */
    public List<FullCar> findFullCarByUserId(int userId) {
        List<FullCar> fullCarList = carRepositoryImpl.findFullCarByUserId(userId);
        return fullCarList;
    }

    /**
     * 添加购物车
     * @param car
     * @return
     */
    public CarEntity save(Car car) {
        CarEntity existsEntity = carRepository.findByUserIdAndGoodsIdAndActive(car.getUserId(), car.getGoodsId(),car.getActive());
        if(existsEntity!=null){
            existsEntity.setQuantity(existsEntity.getQuantity()+car.getQuantity());
            return carRepository.save(existsEntity);
        }else {
            CarEntity carEntity = ShopUtils.convert(car, CarEntity.class);
            return carRepository.save(carEntity);
        }
    }
}
