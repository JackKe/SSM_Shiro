package cn.likegirl.controller.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DefaultExceptionHandler {
    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({UnauthorizedException.class})
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.setViewName("unauthorized");
        return mv;
    }


    /**
     * 账号不存在 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({UnknownAccountException.class})
    public ModelAndView processUnknownAccountException(NativeWebRequest request, UnknownAccountException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.setViewName("login");
        return mv;
    }

    /**
     * 凭证不正确 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({IncorrectCredentialsException.class})
    public ModelAndView processIncorrectCredentialsException(NativeWebRequest request, IncorrectCredentialsException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.setViewName("login");
        return mv;
    }

    /**
     * 账号锁定 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({LockedAccountException.class})
    @ResponseBody
    public Map<String,Object> lockedAccountException(NativeWebRequest request, LockedAccountException e) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("result","error");
        resultMap.put("message",e.getMessage());
        return resultMap;
    }

}
