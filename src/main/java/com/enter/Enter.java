package com.enter;
/*
-p /Users/qi/javafx-sdk-11.0.2/lib --add-modules javafx.controls
 */

import com.entity.User;
import com.utils.HttpClientUtil;
import com.utils.JsonUtils;
import com.view.Login_View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.SneakyThrows;

import java.util.*;
import java.util.List;

public class Enter {
    public static void main(String[] args) {
        Application.launch(Login_View.class,args);
//        Login_Service.login();
//        -p /Users/qi/javafx-sdk-11.0.2/lib --add-modules=javafx.controls,javafx.fxml

//        Application.launch(tesrt.class,args);

//        HashMap<String,Integer> hashMap = new HashMap<>();
//        hashMap.put("1",1);
//
//        System.out.println(hashMap.get("1") == null);
    }

}


class Listener_Test {

    public void lTest() {

        MyEventSource mes = new MyEventSource();
        mes.addMyEventListener(new Test2());
        MyThread mythread = new MyThread(mes);
        mythread.start();

    }
}

class MyEvent extends EventObject {
    private Object obj;
    private List<User> users;

    public MyEvent(Object source, List<User> users) {
        super(source);
        this.obj = source;
        this.users = users;
    }

    public Object getObj() {
        return obj;
    }

    public List<User> getsUsers() {
        return users;
    }
}


interface MyEventListener extends EventListener {

    void handleEvent(MyEvent me);

}

class MyEventSource {
    private Vector list = new Vector();
    private List<User> users;


    public MyEventSource() {
        super();
    }

    public void addMyEventListener(MyEventListener me) {
        list.add(me);
    }

    public void deleteMyEventListener(MyEventListener me) {
        list.remove(me);
    }

    public void notifyMyEvent(MyEvent me) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((MyEventListener) it.next()).handleEvent(me);
        }
    }

    public void setUsers() {
        List<User> userLists = select(User.class);
        if (this.users == null) {
            this.users = userLists;
            notifyMyEvent(new MyEvent(this, userLists));
            return;
        }
        if (userLists.size() != this.users.size()) {
            this.users = userLists;
            // 如果改变则执行事件
            notifyMyEvent(new MyEvent(this, userLists));
        }
    }

    static <T> List<T> select(Class<T> clazz) {
        String url = "http://localhost:8081/user/select";
        String result = "null";
        try {
            result = HttpClientUtil.doGet(url);
            return JsonUtils.jsonToList(result, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}


class Test2 implements MyEventListener {

    public void handleEvent(MyEvent me) {
        System.out.println("有更新\n");
        System.out.println(me.getsUsers());
    }
}

class MyThread extends Thread {
    private MyEventSource clazz;

    public MyThread(MyEventSource clazz) {
        this.clazz = clazz;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true)
            clazz.setUsers();
    }

}