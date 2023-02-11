package br.com.rockncodedelivery.util;

public class GenericUtils {

    public String convertAdressToGoogleAddress(String address){
        return address.replaceAll(" ", "%2");
    }

}
