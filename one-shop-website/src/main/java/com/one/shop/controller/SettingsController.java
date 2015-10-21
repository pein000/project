package com.one.shop.controller;

import com.one.shop.consts.SystemVariable;
import com.one.shop.domain.User;
import com.one.shop.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by pein on 2015/10/19.
 */
@Controller
@RequestMapping(value = "settings")
public class SettingsController {


    @Value("${path.photo.upload}")
    private String pathPhotoUpload;

    @Autowired
    private UploadService uploadService;



    @RequestMapping(value = "toSettings",method = RequestMethod.GET)
    public String toSettings() {

        return "/settings/personal_profile";
    }

    @RequestMapping(value = "to_edit_photo",method = RequestMethod.GET)
    public String to_change_photo() {

        return "/settings/edit_photo";
    }

    @RequestMapping(value = "uploadPhoto", method = RequestMethod.POST)
    public String uploadPhoto(MultipartFile file,HttpServletRequest request, HttpSession session) throws IOException {
        User user = (User) session.getAttribute(SystemVariable.SESSION_KEY_USER);
        String photoUrl =request.getContextPath()+"/"+ pathPhotoUpload;
        uploadService.uploadPhoto(photoUrl, file, user);

        //更新session中的user
        User result = uploadService.findUser(user);
        session.setAttribute(SystemVariable.SESSION_KEY_USER, result);
        return "/settings/success_upload";
    }
}
