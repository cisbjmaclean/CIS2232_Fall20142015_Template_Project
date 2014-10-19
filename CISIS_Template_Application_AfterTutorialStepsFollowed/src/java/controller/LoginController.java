package controller;

import business.AccessBO;
import database.CodeValueDAO;
import forms.Login;
import forms.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("login")
public class LoginController {

    private Login login;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("login") Login login) {
        System.out.println("The form was submitted and the username was ***" + login.getUsername() + "***");

        //pass validation if they enter "TEST" and "TEST"
        ModelAndView mv;
        boolean validCredentials = false;
        try {
            validCredentials = AccessBO.validate(login);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (validCredentials){
            //http://stackoverflow.com/questions/14249730/getting-url-to-a-webapp-context-the-base-url
            StringBuffer url = request.getRequestURL();
            String uri = request.getRequestURI();
            String ctx = request.getContextPath();
            String base = url.substring(0, url.length() - uri.length() + ctx.length()) + "/";
            System.out.println("Base url=" + base);
            request.getSession().setAttribute("baseUrl", base);
            CodeValueDAO.loadCodes(request);
            mv = new ModelAndView("main");
        } else {
            mv = new ModelAndView("login");
        }

        return mv;
    }
}
