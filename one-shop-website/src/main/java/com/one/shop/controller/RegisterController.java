package com.one.shop.controller;

import com.one.shop.domain.User;
import com.one.shop.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by pein on 2015/10/18.
 */
@Controller
public class RegisterController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RegisterService registerService;

    /**
     * 前往注册页面
     * @return
     */
    @RequestMapping(value = "toRegister",method = RequestMethod.GET)
    public String toRegister() {

        return "/user/register";
    }

    /**
     * 前往完善资料页面
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "toPrefect",method = RequestMethod.POST)
    public ModelAndView toPrefect(User user,String code, HttpSession session, ModelMap modelMap) {
        String sessionCode = String.valueOf(session.getAttribute("code"));
        if (!code.equalsIgnoreCase(sessionCode)) {
            logger.info("idenfity not equal. session Code ={}, input Code = {}",sessionCode,code);
            return new ModelAndView("/user/register", modelMap);
        }
        modelMap.put("user", user);
        return new ModelAndView("/user/prefect", modelMap);
    }

    /**
     * 前往注册完成页面
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "toCompleteRegister",method = RequestMethod.POST)
    public ModelAndView toCompleteRegister(User user, ModelMap modelMap) {
        User result = registerService.addUser(user);
        modelMap.put("user", result);
        return new ModelAndView("/user/register_completed_register", modelMap);
    }

    /**
     * 验证码
     */
    @RequestMapping(value = "identify",method = RequestMethod.GET)
    public void identify(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        int width = 90;
        int height = 20;
        int codeCount = 4;//定义图片上显示验证码的个数
        int xx = 15;
        int fontHeight = 18;
        int codeY = 16;
        char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
//  Graphics2D gd = buffImg.createGraphics();
        //Graphics2D gd = (Graphics2D) buffImg.getGraphics();
        Graphics gd = buffImg.getGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);

        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        // 设置字体。
        gd.setFont(font);

        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);

        // 随机产生4条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 4; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }

        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;

        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, (i + 1) * xx, codeY);

            // 将产生的四个随机数组合在一起。
            randomCode.append(code);
        }
        // 将四位数字的验证码保存到Session中。
        System.out.print(randomCode);
        session.setAttribute("code", randomCode.toString());

        // 禁止图像缓存。

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。

        try {
            ServletOutputStream sos = response.getOutputStream();
            ImageIO.write(buffImg, "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            logger.info("generate identify code error.");
            e.printStackTrace();
        }

    }
}
