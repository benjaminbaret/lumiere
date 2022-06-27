package vue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssertFields {
    AssertFields(){}

    public boolean isPhoneTextFieldValid(String textFieldString){
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(textFieldString);
        return matcher.matches();
    }

    public boolean isEmailAddressTextFieldValid(String emailFieldString){
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher matcher = pattern.matcher(emailFieldString);
        return matcher.matches();
    }

    public boolean isCardCodeValid(String cardNumber){
        Pattern pattern = Pattern.compile("^4[0-9]{6,}$");
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }

    public boolean isMounthValid(String mounthCard){
        Pattern pattern = Pattern.compile("^(1[0-2]|0[1-9])$");
        Matcher matcher = pattern.matcher(mounthCard);
        return matcher.matches();
    }

    public boolean isYearValid(String yearCard){
        Pattern pattern = Pattern.compile("^(19|20)\\d{2}$$");
        Matcher matcher = pattern.matcher(yearCard);
        return matcher.matches();
    }

    public boolean isSecurityCodeValid(String securityCode){
        Pattern pattern = Pattern.compile("[1-9]\\d\\d");
        Matcher matcher = pattern.matcher(securityCode);
        return matcher.matches();
    }
    
}
