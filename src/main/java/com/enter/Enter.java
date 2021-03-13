package com.enter;
/*
-p /Users/qi/javafx-sdk-11.0.2/lib --add-modules javafx.controls
 */
import com.service.Login_Service;
import com.service.Registration_Service;
import com.service.Server_Contention_Service;
import com.utils.Base64Util;
import com.utils.HttpClientUtil;
import com.utils.JsonUtils;
import com.view.Login_View;
import javafx.application.Application;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Enter {
    public static void main(String[] args) {
        Application.launch(Login_View.class,args);
//        Login_Service.login();
    }


}