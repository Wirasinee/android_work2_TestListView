package com.example.testlistview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testlistview.R;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wirasinee on 29-Oct-17.
 */
//[5]
public class AnimalListAdapter extends ArrayAdapter<Animal> {
    private Context mContext; //ใครก็ตามที่เรียกใช้คลาสนี้ต้องส่งcontextมาให้เรา
    private ArrayList<Animal> mAnimalList;//ตัวข้อมูล
    private int mLayoutResId; //ตัวเลเอาแต่ละไอเทม

//ต้องส่ง context ,resource อยากให้เลเอาเป็นแบบไหน ,objects แหล่งข้อมูลที่เก็บทั้งหมด
    public AnimalListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Animal> objects) {
        super(context, resource, objects);
        //ALT+INSERT+อันที่5+non

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mAnimalList = objects;
    }

    //CTRL+Oเลือก getView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //ตอนนี้เรากำลังจะสร้างอแดปเตอขึ้นมาเอง
        LayoutInflater inflater = LayoutInflater.from(mContext);//อินเฟคเลเอาโดยใช้LayoutInflater
        View v = inflater.inflate(mLayoutResId,null);//ระบุว่าไฟล์เลเอาที่จะอินเฟค

        //ค้นหาตัววิวที่อยู่ภายในv
        ImageView iv = v.findViewById(R.id.imageView);
        TextView tv = v.findViewById(R.id.textView);

        //ดึงข้อมูลจากแหล้งข้อมูลแล้วยัดข้อมูลลงไป เอาชื่อกับรูปภาพใส่เข้าไป
        Animal animal = mAnimalList.get(position);//ดึงเฉพาะโบกี(ข้อมูลobj)ตำแหน่งนั้นๆ (objนั้นๆ)
        iv.setImageResource(animal.picture);//จะได้รูปภาพไรก็ขึ้นอยู่กับ position ว่าlistViewขอpositionไหนมา
        tv.setText(animal.name);

        return v;//รีเทินก้อนนั้นๆ
    }
}
