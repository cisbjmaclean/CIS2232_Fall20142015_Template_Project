package controller;

import beans.CodeValue;
import forms.Menu;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("editCodeValue")
public class ChooseEditCodeController {

    /**
     * This is the get method for the edit codes.  See tutorial for details.
     * 
     * @author BJ MacLean
     * @since 20141018
     */
        
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView onGet(@RequestParam Map<String, String> allRequestParams) {

        System.out.println("The code type we are going to edit is:" + allRequestParams.get("codeTypeId"));
        System.out.println("The code value we are going to edit is:" + allRequestParams.get("codeValueSequence"));
        
        //Take the parameters and create a CodeValue bean that is put in the MV
        CodeValue cv = new CodeValue(allRequestParams.get("description"),
                allRequestParams.get("shortDescription"),
                Integer.parseInt(allRequestParams.get("codeTypeId")),
                Integer.parseInt(allRequestParams.get("codeValueSequence")));

        ModelAndView mv = new ModelAndView("editCodeValue"); //This will send to editCodeValue tile.
        mv.addObject("thisCode", cv);
        return mv;
    }

     /**
     * This is the POST method for the edit codes.  See tutorial for details.
     * 
     * @author BJ MacLean
     * @since 20141018
     */

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("thisCode") CodeValue codeValue) {
        //This is not completed.
        System.out.println("Would have to add code here to actually save changes to the database");
        ModelAndView mv;
        mv = new ModelAndView("welcome");  //Send user back to the welcome
        return mv;
    }
}
