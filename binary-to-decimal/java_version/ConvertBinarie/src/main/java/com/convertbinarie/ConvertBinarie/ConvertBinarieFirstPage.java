package com.convertbinarie.ConvertBinarie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convertbinarie.ConvertBinarie.ConvertRequest;

@Controller
public class ConvertBinarieFirstPage {

    @GetMapping("/")
    public String index() {
        return "html_css_and_javascript";
    }

    @PostMapping("convert-value")
    @ResponseBody
    public String postMethodName(@RequestBody ConvertRequest request) {
        
        String value = request.getValue();
//        String valueIn = request.getValueIn();
  //      String convertIn = request.getConvertIn();
        int count = 0;
        int result = 0;

        // convert binary in decimal
        for (int stringLen = value.length()-1; stringLen >= 0; stringLen--) {
            char charInString = value.charAt(stringLen);
            int number = Character.getNumericValue(charInString);
            result = result + (number * (int)Math.pow(2, count));
            count++;
        }

        return String.valueOf(result);
    }
    
    
}
