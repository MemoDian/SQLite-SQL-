package com.memo.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ÿһ���������Լ������ݿ�,Ĭ��������Ǹ��Ի�������
		// ����һ�����ݿ�,���Ҵ�(�������,ֱ�Ӵ�)
		SQLiteDatabase db = openOrCreateDatabase("Dota.db", MODE_PRIVATE, null);
		db.execSQL("create table if not exists Dotatb(_id integer primary key autoincrement, name text not null,age integer not null,sex text not null)");
		db.execSQL("insert into Dotatb(name,sex,age) values('����','Ů',18)");
		db.execSQL("insert into Dotatb(name,sex,age) values('����','��',19)");
		db.execSQL("insert into Dotatb(name,sex,age) values('����','Ů',20)");
		/**
		 * ��ѯ
		 * Cursor ��һ���������ݼ��ϵ���,ϵͳ�����Զ��ͷ�
		 * ������ݷǳ���,Ӧ���ֶ��ͷ�
		 * �ȸ��ƴ��ֶ��ͷ�
		 * 
		 * Cursor:�α�ӿ�,�ṩ�˱�����ѯ����ķ���,���ƶ�ָ�뷽��move(),�����ֵ����getString()��.
		 * ���÷���:
		 * 		getCount()	�ܼ�¼����
		 * 		isFirst()	�ж��Ƿ��һ����¼
		 * 		isLast()	�ж��Ƿ����һ����¼
		 * 		moveToFirst()	�ƶ�����һ����¼
		 * 		moveToLast()	�ƶ������һ����¼
		 * 		move(int offset)	�ƶ���ָ����¼
		 * 		moveTONext()	�ƶ�����һ����¼
		 * 		moveToPrevious()	�ƶ�����һ����¼
		 * 		getColumnIndexOrThrow(String columnName)	�������ƻ��������
		 * 		getInt(int columnIndex)		���ָ����������int����ֵ
		 * 		getString(int columnIndex)	���ָ����������String����ֵ
		 */
		Cursor c = db.rawQuery("select * from Dotatb", null);
		if(c!= null){
			while(c.moveToNext()){
				Log.i("info", "_id:"+c.getInt(c.getColumnIndex("_id")));
				Log.i("info", "name:"+c.getShort(c.getColumnIndex("name")));
				Log.i("info", "age:"+c.getInt(c.getColumnIndex("age")));
				Log.i("info", "sex:"+c.getString(c.getColumnIndex("sex")));
			}
			c.close();
		}
		db.close();
	}
}
