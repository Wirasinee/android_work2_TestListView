package com.example.testlistview.model;
//[4]
/**
 * Created by Wirasinee on 29-Oct-17.
 */

public class Animal {
    public final String name;
    public final int picture;//รีซอสidของรูป //R.ต่างๆมันเป็นค่าคงที่(เป็นint)

    public Animal(String name, int picture) { //ALT+INSERT
        this.name = name;
        this.picture = picture;
    }
}
