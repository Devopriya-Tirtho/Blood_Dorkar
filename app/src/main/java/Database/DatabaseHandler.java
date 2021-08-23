package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Model.Contact;
import Model.Donor;


public class DatabaseHandler extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION=3;
	private static final String DATABASE_NAME="Blood_bank";
	private static final String TABLE_NAME="Sign_Up";
	private static final String KEY_ID="id";
	private static final String KEY_NAME="name";
	private static final String KEY_PASSWORD="password";
	private static final String KEY_EMAIL="email";
	private static final String KEY_CONTACTNO="phoneNo";


    private static final String TABLE_NAME1="Donor_Reg";
    private static final String KEY_Age="age";
    private static final String KEY_Address="address";
    private static final String KEY_Blood="bloodgroup";



	Context context;
	
	public DatabaseHandler(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		//Log.v("db created", "yes");
		String CREATE_CONTACT_TABLE="CREATE TABLE "+ TABLE_NAME +"("
									+ KEY_ID +" INTEGER PRIMARY KEY,"
									+ KEY_NAME +" TEXT,"
									+ KEY_CONTACTNO +" TEXT" +")";

		String sql= "CREATE TABLE Sign_Up (ID INTEGER PRIMARY KEY,  NAME TEXT,PASSWORD TEXT,EMAIL TEXT, PHONENO TEXT)";
		db.execSQL(sql);

        String sql1= "CREATE TABLE Donor_Reg (ID INTEGER PRIMARY KEY,  NAME TEXT,BLOODGROUP TEXT,AGE TEXT,ADDRESS TEXT, PHONENO TEXT)";
        db.execSQL(sql1);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql = "DROP TABLE IF EXISTS Sign_Up";
		db.execSQL(sql);
		String sql1 = "DROP TABLE IF EXISTS Donor_Reg";
		db.execSQL(sql);
		onCreate(db);
	}
	public void addContact(Contact contact)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues value=new ContentValues();
		value.put(KEY_NAME, contact.getName());
		value.put(KEY_PASSWORD, contact.getPassword());
		value.put(KEY_EMAIL, contact.getEmail());
		value.put(KEY_CONTACTNO,contact.getContactNumber());

		db.insert(TABLE_NAME, null,value);

		db.close();
		
	}

	public Boolean loginCheck(String name,String password)
	{
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
		Boolean result=false;
			while (cursor.moveToNext())
			{
				String uname=cursor.getString(1);
				String upassword=cursor.getString(2);
				if(uname.equals(name) && upassword.equals(password))
				{
					result=true;
					break;
				}
			}

		return result;
	}

    public void addDonor(Donor donor) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues value1=new ContentValues();
        value1.put(KEY_NAME, donor.get_name());
        value1.put(KEY_Blood, donor.get_bloodgroup());
        value1.put(KEY_Age, donor.get_age());
        value1.put(KEY_Address,donor.get_address());
        value1.put(KEY_CONTACTNO,donor.get_phoneNumber());

        db.insert(TABLE_NAME1, null,value1);

        db.close();


    }

	public List<Donor> getAllContact(String grp)
	{
		List<Donor> mycontactList=new ArrayList<Donor>();


		String selectquery="SELECT * FROM "+TABLE_NAME1+" WHERE "+KEY_Blood+" LIKE '%"+grp+"%'";
		SQLiteDatabase db=this.getReadableDatabase();

		Cursor cursor=db.rawQuery(selectquery, null);

		if(cursor.moveToFirst())
		{
			do
			{
				Donor donor= new Donor(cursor.getString(1),cursor.getString(2),cursor.getString(5));
				mycontactList.add(donor);
			}while(cursor.moveToNext());
		}

		return mycontactList;
	}

	public List<Donor> getAllAddress(String address_name)
	{
		List<Donor> mycontactList=new ArrayList<Donor>();


		String selectquery="SELECT * FROM "+TABLE_NAME1+" WHERE "+KEY_Address+" LIKE '%"+address_name+"%'";
		SQLiteDatabase db=this.getReadableDatabase();

		Cursor cursor=db.rawQuery(selectquery, null);

		if(cursor.moveToFirst())
		{
			do
			{
				Donor donor= new Donor(cursor.getString(1),cursor.getString(2),cursor.getString(5),cursor.getString(4));
				mycontactList.add(donor);
			}while(cursor.moveToNext());
		}

		return mycontactList;
	}


}
