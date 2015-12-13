package com.online.video.util;

import jodd.bean.BeanCopy;
import jodd.bean.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/10/14.
 */
public class ConvertUtils {

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

    public static <T, D> List<T> convert(List<D> entityList, Class<T> clazz, String... includes) {
        if (entityList == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        for (D entity : entityList) {
            try {
                T dest = clazz.newInstance();
                BeanCopy.beans(entity, dest).include(includes).copy();
                list.add(dest);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return list;
    }

    public static <E> E setProperties(E source, String property, Object value) {
        BeanUtil.setProperty(source, property, value);
        return source;
    }

    public static <E> List<E> setProperties(List<E> source, String property, Object value) {
        for (E e : source) {
            BeanUtil.setProperty(e, property, value);
        }
        return source;
    }

}
