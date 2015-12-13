package com.online.video.service;

import com.online.video.vo.VideoResponse;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by pein on 2015/12/10.
 */
@Service
public class NativeUploadService {

    /**
     * 上传到本地服务器目录
     *
     * @return
     */
    public VideoResponse upload(String path, MultipartFile file) throws IOException {
        File pathFile = new File(path);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        String fullName = path + File.separator + file.getOriginalFilename();
        File fullFile = new File(fullName);
        if (!fullFile.exists()) {
            fullFile.createNewFile();
        }
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fullFile));
        stream.write(file.getBytes());
        stream.close();
        return new VideoResponse(file.getOriginalFilename(), fullName);
    }

    public String upload(String path, HttpServletRequest request, RequestContext requestContext) throws Exception {
        RequestContext  requestcontext = new ServletRequestContext(request);
        StandardMultipartHttpServletRequest multipartHttpServletRequest = (StandardMultipartHttpServletRequest) request;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        Iterator<String> filenames = multipartHttpServletRequest.getFileNames();
        MultipartFile file = multipartHttpServletRequest.getFile(filenames.next());

        File pathFile = new File(path);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        File fullFile = new File(path + File.separator + file.getOriginalFilename());
        if (!fullFile.exists()) {
            fullFile.createNewFile();
        }
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fullFile));
        stream.write(file.getBytes());
        stream.close();

        return fullFile.getAbsolutePath();
//        if (isMultipart) {
//            FileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            FileUploadBase.isMultipartContent(requestContext);
//            // 得到所有的表单域，它们目前都被当作FileItem
//            FileUpload fileUpload = new FileUpload(factory);
//            fileUpload.setHeaderEncoding("utf-8");
//            List<FileItem> a =  fileUpload.parseRequest(requestContext);
//            List<FileItem> fileItems = upload.parseRequest(request);
//            upload.parseRequest(multipartHttpServletRequest);
//            Iterator<FileItem> iter = fileItems.iterator();
//            while (iter.hasNext()) {
//                FileItem item = iter.next();
//                if (!item.isFormField()) {//非表单域即文件域
//                    String fileName = item.getName();
//                    if (fileName != null) {
//                        File pathFile = new File(path);
//                        if (!pathFile.exists()) {
//                            pathFile.mkdirs();
//                        }
//                        File fullFile = new File(path, fileName);
//                        if (!fullFile.exists()) {
//                            fullFile.createNewFile();
//                        }
//                        item.write(fullFile);
//                        return fullFile.getAbsolutePath();
//                    }
//                }
//            }
//        }
//        return null;
    }
}
