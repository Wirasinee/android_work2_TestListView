package com.example.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testlistview.adapter.AnimalListAdapter;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;
//[2]
public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    //private ArrayList<String> mData;//(1)
    //private ArrayList<Animal> mData;//(10)อยากทำให้มันเป็นคนละรูปกัน ไปที่[4] Animal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list_view);

        final AnimalData animalData = AnimalData.getInstance();//(18) สร้างobj animalDataแบบอซิงโครตัน
        animalData.animalList = new ArrayList<>();//(19)animalListตัวแปลแบบโกโบล


        //mData = new ArrayList<>();(1)

        Animal animal = new Animal("แมว (Cat)",R.drawable.cat,getString(R.string.details_cat));
        animalData.animalList.add(animal);
        animalData.animalList.add(new Animal("หมา (Dog)",R.drawable.dog,getString(R.string.details_dog)));
        animalData.animalList.add(new Animal("โลมา (Dolphin)",R.drawable.dolphin,getString(R.string.details_dolphin)));
        animalData.animalList.add(new Animal("โคอาลา (Koala)",R.drawable.koala,getString(R.string.details_koala)));
        animalData.animalList.add(new Animal("สิงโต (Lion)",R.drawable.lion,getString(R.string.details_lion)));
        animalData.animalList.add(new Animal("นกฮูก (Owl)",R.drawable.owl,getString(R.string.details_owl)));
        animalData.animalList.add(new Animal("เพนกวิ้น (Penguin)",R.drawable.penguin,getString(R.string.details_penguin)));
        animalData.animalList.add(new Animal("หมู (Pig)",R.drawable.pig,getString(R.string.details_pig)));
        animalData.animalList.add(new Animal("กระต่าย (Rabbit)",R.drawable.rabbit,getString(R.string.details_rabbit)));
        animalData.animalList.add(new Animal("เสือ (Tiger)",R.drawable.tiger,getString(R.string.details_tiger)));
        //จะเอาข้อมูลมาแสดงในListViewต้องใช้ Adapterเชือมโยงรหว่างListViewกับmDate   ที่นีเี่ใช้ ArrayAdaptwe:กรณีข้อมูลเราเป็นarray หรือ arraylist

        /*(5)
        (2)
        ArrayAdapter<Animal> adapter = new ArrayAdapter<String>(
                this,
                //(6)//(3)android.R.layout.simple_list_item_1,//เลเอา item1เป็นรูปแบบที่มีให้ยุแล้ว //Layout ของแต่ละitemในListView ถ้าอยากให่หน้าตาต่างกันต้องทำเพิ่ม(ทำมากกว่านี้)
                R.layout.item,//(6) รูปแบบเลเอาที่เราทำไว้ในres->layout->item.xml (หน้าตา)   ไป[3] item.xml กรณีอยากสร้างรูปแบบเลเอาเอง
                R.id.textView,//(7) idตัวรูปแบบที่เราสร้าง กรณีใช้แบบพืนฐานที่มีให้อยู่แล้วไม่ต้องมีบรรทัดนี้เช่นมี(3)ไม่ต้องมีอันนี้ (บอกมันว่าข้อมูลที่ได้มา เอามาใส่ตรงid textViewของlayout.itemนะ) [ถึงขั้นนี้ถ้ารันจะเป็นลิสรูปแอนครอยกับข้อความcat dog]
                mData//แหล่งข้อมูล
        );*/
//(11)เนื่องจากadapterข้างบนไม่สามารถทำรูปแบบเปลียนรูปและข้ความได้เราจึงต้องสร้างขึ้นมาเอง ไปAnimalListAdapter [5]
        //(12)
        AnimalListAdapter adapter = new AnimalListAdapter(
                this,
                R.layout.item,//คอนเทค เลเอา รูปแบบ
                //mData//(13)แหล่งข้อมูลทั้งหมด
                animalData.animalList
        );

//(4) setตัวกลาง
        mListView.setAdapter(adapter);
//(8) คลิกที่ลิสนั้นๆแล้วแสดง... setOnItemClickListener คือคักอีเว้นของแต่ละitemนะ
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {//iคือตำแหน่งลำดับitemนั้น
               /*(9) Animal animalName = mData.get(i);//ชื่อสัตว์ที่ผู้ใช้เลือก
                Toast.makeText(MainActivity.this,animalName,Toast.LENGTH_LONG).show();*/

               /*(14)Animal animal = mData.get(i);//ชื่อสัตว์ที่ผู้ใช้เลือก
                Toast.makeText(MainActivity.this,animal.name,Toast.LENGTH_LONG).show();*/

                Animal animal = animalData.animalList.get(i);//ชื่อสัตว์ที่ผู้ใช้เลือก
                Toast.makeText(MainActivity.this,animal.name,Toast.LENGTH_LONG).show();

                //(15)ถ้าให้แสดงชื่อสัตว?หน้าใหม่ทำไง ใช้อินเทนไงละ>.< สร้าง AnimalDetailsActivity [6]
                Intent intent = new Intent(MainActivity.this,AnimalDetailsActivity.class);
                //(16)intent.putExtra("name",animal.name);
                //(16)intent.putExtra("picture",animal.picture);//CTRL+Qดูชนิดข้อมูล/เมธอทนั้นไว้ทำไร (16)เป็นวิธีส่งข้อมูลไปให้ปลายทางแบบธรรมดา กรณีมีข้อมูลส่งน้อยๆใช้ได้

                ///(17)ถ้าข้อมูลเราเยอะไม่ควรputที่ละอีนแบบนี้เราควรให้mDataไปเป็นตัวแปลแบบโกโบลเลย แล้วส่งไปแค่i(ตำแหน่งที่ผู้ใช้คลิก)พอ โดยสร้างclassใมห่ [7]AnimalData

                intent.putExtra("position", i);//(19) ใส่แค่ index พอแล้ว แต่เวลาปลายทางเข้าถึงจะเข้าถึงอซิงโครตันก็จะได้animalList
                startActivity(intent);


            }
        });



    }
}
