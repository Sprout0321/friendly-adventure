package tw.com.ecomuniversal.ecomtest5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SproutDatabaseAdapter {
	private static final String TAG = "SproutDatabaseAdapter";
	SproutSQLiteOpenHelper sproutSQLiteOpenHelper;
	
	public SproutDatabaseAdapter(Context context, String name, CursorFactory factory, int version) {
		sproutSQLiteOpenHelper = new SproutSQLiteOpenHelper(context, name, factory, version);
	}
	
	public SproutDatabaseAdapter(Context context, String name, int version) {
		sproutSQLiteOpenHelper = new SproutSQLiteOpenHelper(context, name, version);
	}
	
	public SproutDatabaseAdapter(Context context, String name) {
		sproutSQLiteOpenHelper = new SproutSQLiteOpenHelper(context, name);
	}
	
	public SproutDatabaseAdapter(Context context) {
		sproutSQLiteOpenHelper = new SproutSQLiteOpenHelper(context);
	}
	
	public void getWritableDatabase() {
		sproutSQLiteOpenHelper.getWritableDatabase();
	}
	
	public long insertData(String titleName, Integer groupNumber, String colorName, Boolean checkTrue){
		SQLiteDatabase sqlDatabase = sproutSQLiteOpenHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(SproutSQLiteOpenHelper.TITLE, titleName);
		contentValues.put(SproutSQLiteOpenHelper.GROUP, groupNumber);
		contentValues.put(SproutSQLiteOpenHelper.COLOR, colorName);
		contentValues.put(SproutSQLiteOpenHelper.CHECK, checkTrue);
		Long id = sqlDatabase.insert(SproutSQLiteOpenHelper.TABLE_NAME, null, contentValues);
		Log.i(TAG + " > insertData()", "id = " + id);
		return id;
	}
	
	public Cursor getAllData() {
		SQLiteDatabase sQLiteDatabase = sproutSQLiteOpenHelper.getWritableDatabase();
		// SELECT _ID, titleName, groupNumber, colorName, checkTrue FROM SproutTable1
		String[] columnsArray = {SproutSQLiteOpenHelper.UID,
				SproutSQLiteOpenHelper.TITLE,
				SproutSQLiteOpenHelper.GROUP,
				SproutSQLiteOpenHelper.COLOR,
				SproutSQLiteOpenHelper.CHECK};
		Cursor cursor = sQLiteDatabase.query(SproutSQLiteOpenHelper.TABLE_NAME, columnsArray, null, null, null, null, null);
		StringBuffer stringBuffer = new StringBuffer();
		Integer count = cursor.getCount();
		Log.i(TAG + " > getAllData()", "count = " + count.toString());
		while (cursor.moveToNext()) {
			Integer index_id = cursor.getColumnIndex(SproutSQLiteOpenHelper.UID);
			Integer index_titleName = cursor.getColumnIndex(SproutSQLiteOpenHelper.TITLE);
			Integer index_groupNumber = cursor.getColumnIndex(SproutSQLiteOpenHelper.GROUP);
			Integer index_colorName = cursor.getColumnIndex(SproutSQLiteOpenHelper.COLOR);
			Integer index_checkTrue = cursor.getColumnIndex(SproutSQLiteOpenHelper.CHECK);
			Integer _id = cursor.getInt(index_id);
			String titleName = cursor.getString(index_titleName);
			Integer groupNumber = cursor.getInt(index_groupNumber);
			String colorName = cursor.getString(index_colorName);
			Boolean checkTrue = cursor.getInt(index_checkTrue) > 0;
			stringBuffer.append(_id + " " + titleName + " " + groupNumber + " " + colorName + " " + checkTrue + "\n");
		}
		Log.i(TAG + " > getAllData()", "stringBuffer.toString() = " + stringBuffer.toString());
//		return stringBuffer.toString();
		return cursor;
	}
	
	public Cursor getDataByCheckTrue() {
		// SELECT _ID, titleName, colorName FROM SproutTable1 WHERE checkTrue=?
		SQLiteDatabase sQLiteDatabase = sproutSQLiteOpenHelper.getWritableDatabase();
		String[] columnsArray = {SproutSQLiteOpenHelper.UID,
				SproutSQLiteOpenHelper.TITLE,
				SproutSQLiteOpenHelper.COLOR};
		String selectionString = SproutSQLiteOpenHelper.CHECK + " =?";
		String[] selectionArray = {booleanToString(true)};
		Cursor cursor = sQLiteDatabase.query(SproutSQLiteOpenHelper.TABLE_NAME,
				columnsArray, selectionString, selectionArray,
				null, null, null);
		return cursor;
	}
	
	public Cursor getDataByGroup(Integer group) {
		// SELECT _ID, titleName, colorName, checkTrue FROM SproutTable1 WHERE groupNumber=?
		SQLiteDatabase sQLiteDatabase = sproutSQLiteOpenHelper.getWritableDatabase();
		String[] columnsArray = {SproutSQLiteOpenHelper.UID,
				SproutSQLiteOpenHelper.TITLE,
				SproutSQLiteOpenHelper.COLOR,
				SproutSQLiteOpenHelper.CHECK};
		String selectionString = SproutSQLiteOpenHelper.GROUP + " =?";
		String[] selectionArray = {group.toString()};
		Cursor cursor = sQLiteDatabase.query(SproutSQLiteOpenHelper.TABLE_NAME,
				columnsArray, selectionString, selectionArray,
				null, null, null);
		return cursor;
	}
	
	public void updateCheckTrue(Integer _ID, Boolean CheckTrue) {
		// UPDATE SproutTable1 SET checkTrue=? WHERE _ID=?
		SQLiteDatabase sQLiteDatabase = sproutSQLiteOpenHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(SproutSQLiteOpenHelper.CHECK, CheckTrue);
		String selectionString = SproutSQLiteOpenHelper.UID + " =?";
		String[] selectionArray = {_ID.toString()};
		sQLiteDatabase.update(SproutSQLiteOpenHelper.TABLE_NAME, contentValues, selectionString, selectionArray);
	}
	
	
	
	public String getID(String titleName, Integer groupNumber, String colorName, Boolean checkTrue) {
		// SELECT _ID FROM SproutTable1 WHERE titleName=? AND groupNumber=? AND colorName=? AND checkTrue=?
		SQLiteDatabase sqlDatabase = sproutSQLiteOpenHelper.getWritableDatabase();
		
		String[] columnsArray = {SproutSQLiteOpenHelper.UID};
		String selectionString = SproutSQLiteOpenHelper.TITLE + " =? AND "
				+ SproutSQLiteOpenHelper.GROUP + " =? AND "
				+ SproutSQLiteOpenHelper.COLOR + " =? AND "
				+ SproutSQLiteOpenHelper.CHECK + " =?";
		String[] selectionArray = {titleName,
				groupNumber.toString(),
				colorName,
				booleanToString(checkTrue)};
		Cursor cursor = sqlDatabase.query(SproutSQLiteOpenHelper.TABLE_NAME,
				columnsArray, selectionString, selectionArray,
				null, null, null);
		StringBuffer stringBuffer = new StringBuffer();
		while (cursor.moveToNext()) {
			Integer index_id = cursor.getColumnIndex(SproutSQLiteOpenHelper.UID);
			String _id = cursor.getString(index_id);
			stringBuffer.append(_id + "\n");
		}
		Log.i(TAG + " > getData()", "stringBuffer.toString() = " + stringBuffer.toString());
		return stringBuffer.toString();
	}
	
	private String booleanToString(Boolean myBoolean) {
		Integer booleanInteger = Boolean.valueOf(myBoolean).compareTo(false);
		String booleanString = booleanInteger.toString();
		return booleanString;
	}
	
	static class SproutSQLiteOpenHelper extends SQLiteOpenHelper {
		private static final String TAG = "SproutSQLiteOpenHelper";
		private Context context;
		// 資料庫名
		private static final String DATABASE_NAME = "SproutDataBase";
		// 表名
		private static final String TABLE_NAME = "SproutTable1";
		// 資料庫版本，關係到App更新時，資料庫是否要調用onUpgrade()
		private static final Integer DATABASE_VERSION = 1;
		// 表格欄位名稱: _ID, titleName, groupNumber, colorName, checkTrue
		private static final String UID = "_ID";
		private static final String TITLE = "titleName";
		private static final String GROUP = "groupNumber"; //名稱用 "GROUP", "Group", "group" 會create table失敗
		private static final String COLOR = "colorName";
		private static final String CHECK = "checkTrue";
		// 創建表格字串
		private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
				+ " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
				+ TITLE + " NVARCHAR(10), "
				+ GROUP + " INT, "
				+ COLOR + " VARCHAR(10), "
				+ CHECK + " BOOLEAN);";
		// 刪除表格字串
		private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
		
		// 建構子
		public SproutSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
			super(context, name, factory, version);
			this.context = context;
			Log.i(TAG + " > SproutSQLiteOpenHelper", "Constructor(4) called");
		}
		
		public SproutSQLiteOpenHelper(Context context, String name, int version) {
			this(context, name, null, version);
			this.context = context;
			Log.i(TAG + " > SproutSQLiteOpenHelper", "Constructor(3) called");
		}

		public SproutSQLiteOpenHelper(Context context, String name) {
			this(context, name, null, DATABASE_VERSION);
			this.context = context;
			Log.i(TAG + " > SproutSQLiteOpenHelper", "Constructor(2) called");
		}
		
		public SproutSQLiteOpenHelper(Context context) {
			this(context, DATABASE_NAME, null, DATABASE_VERSION);
			this.context = context;
			Log.i(TAG + " > SproutSQLiteOpenHelper", "Constructor(1) called");
		}

		// 輔助類建立時運行該方法
		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				Log.i(TAG + " > onCreate()", "onCreate() called");
				db.execSQL(CREATE_TABLE);
			} catch (SQLException e) {
				Log.e(TAG + " > onCreate()", e.toString());
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// oldVersion=舊的資料庫版本；newVersion=新的資料庫版本
			try {
				Log.i(TAG + " > onUpgrade()", "onUpgrade() called");
				// 刪除舊有的資料表
				db.execSQL(DROP_TABLE);
				onCreate(db);
			} catch (SQLException e) {
				Log.e(TAG + " > onUpgrade()", e.toString());
			}
		}

		@Override
		public void onOpen(SQLiteDatabase db) {
			super.onOpen(db);
			// TODO 每次成功打開數據庫後首先被執行
		}

		@Override
		public synchronized void close() {
			super.close();
		}

	}
}
