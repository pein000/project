package com.one.shop.service;

import com.one.shop.domain.User;
import com.one.shop.entity.UserEntity;
import com.one.shop.repository.UserRepository;
import com.one.shop.util.ShopUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by pein on 2015/10/19.
 */
@Service
public class UploadService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String FILE_NAME_SPERATOR = "_";

    private static final String FILE_SUFFIEX_NAME = ".JPG";

    @Autowired
    private UserRepository userRepository;

    /**
     * 图片上传
     * 将图片转换成byte[]，再通过写入流
     * 写入到图片服务器中。
     *
     * @param photoUrl
     * @param file
     * @throws IOException
     */
    @Transactional
    public void uploadPhoto(String photoUrl, MultipartFile file, User user) throws IOException {
        File nativePath = new File(photoUrl);
        if (!nativePath.exists()) {
            nativePath.mkdirs();
        }
        String name = photoUrl + user.getName() + FILE_NAME_SPERATOR + user.getPhone() + FILE_SUFFIEX_NAME;
        File nativeFile = new File(name);
        if (!nativeFile.exists()) {
            nativeFile.createNewFile();
        }

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nativeFile));
        bos.write(file.getBytes());
        bos.close();

        user.setPhotoUrl(name);

        UserEntity userEntity = ShopUtils.convert(user, UserEntity.class);
        userRepository.save(userEntity);
        logger.info("success to upload photo . url = {}", name);
    }

    public User findUser(User user) {
        UserEntity userEntity = userRepository.findOne(user.getId());
        if (userEntity == null) {
            logger.info("no user found by user . user = {}", user);
        }

        User result = ShopUtils.convert(userEntity, User.class);
        return result;
    }

}
