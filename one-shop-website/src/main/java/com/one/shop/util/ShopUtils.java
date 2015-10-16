package com.one.shop.util;

import jodd.bean.BeanCopy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/10/14.
 */
public class ShopUtils {

    public static <T, D> T convert(D source, Class<T> destClazz) {
        T destination = null;
        try {
            destination = destClazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        BeanCopy.beans(source, destination).copy();
        return destination;
    }

    public static <T, D> List<T> convert(Iterable<D> entityIterable, Class<T> clazz) {
        if (entityIterable == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        for (D entity : entityIterable) {
            try {
                T dest = clazz.newInstance();
                BeanCopy.beans(entity, dest).copy();
                list.add(dest);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return list;
    }

    public static <T, D> List<T> convert(List<D> entityList, Class<T> clazz) {
        if (entityList == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        for (D entity : entityList) {
            try {
                T dest = clazz.newInstance();
                BeanCopy.beans(entity, dest).copy();
                list.add(dest);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return list;
    }

//    public static void main(String[] args) {
//        List<TypeEntity> typeEntityList = new ArrayList<TypeEntity>();
//        for (int i = 0; i < 10; i++) {
//            TypeEntity typeEntity = new TypeEntity();
//            typeEntity.setName("aaa" + i);
//            typeEntity.setId(i);
//            typeEntity.setUrl("/ss/oo/dd");
//            typeEntityList.add(typeEntity);
//        }
//
//        List<Type> typeList = convert(typeEntityList, Type.class);
//        int i = 0;
//        int b = 1;
//
//    }
}
