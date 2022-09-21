package com.example.baitapvenha;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerBai1 {
    @GetMapping("bai1")
    public String bai1(@RequestParam(name = "str1")String str1,
                       @RequestParam(name = "str2")String str2,
                       Model model){
        String text;
        if(str1.length() > str2.length()){
            text = str1;
        } else if (str1.length() == str2.length()) {
            text = "2 Chuoi = Nhau";
        } else {
            text = str2;
        }
        model.addAttribute("text",text);
        return "bai1";
    }

    @GetMapping("bai2")
    public String bai2(@RequestParam(name = "str")String text,
                       Model model){
        StringBuffer strbff = new StringBuffer(text);
        model.addAttribute("text",strbff.reverse().toString());
        return "bai2";
    }
    @GetMapping("bai3")
    public String bai3(@RequestParam(name = "number")Integer number,
                       Model model){
        for (int i = number+1;; i++) {
            boolean Checked = isPrimeNumber(i);
            if (Checked){
                model.addAttribute("number",i);
                return "bai3";
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
