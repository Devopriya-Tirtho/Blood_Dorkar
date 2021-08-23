package Model;

public class Contact {
	 int _id;
	 String _name;
	 String _phoneNumber,_password,_email;
	 
	 public Contact()
	 {
		 
	 }


	public Contact(String Name , String Password , String Email , String ContactNumber)
	{


		this._name=Name;
		this._password=Password;
		this._email=Email;
		this._phoneNumber=ContactNumber;

	}


	public Contact(String Name, String Password)
	 {
		 this._name=Name;
		 this._password=Password;
			 
	 }

	 
	 public int getId()
	 {
		 return this._id;
	 }
	 public void setId(int Id)
	 {
		 this._id=Id;
	 }
	 
	 public String getName()
	 {
		return this._name;
	 }
	 public void setName(String Name)
	 {
		 this._name=Name;
	 }

	public String getPassword()
	{
		return this._password;
	}
	public void setPassword(String Password)
	{
		this._password=Password;
	}

	public String getEmail()
	{
		return this._email;
	}
	public void getEmail(String Email)
	{
		this._password=Email;
	}
	 
	 public String getContactNumber()
	 {
		return this._phoneNumber;
	 }
	 public void setContactNumber(String ContactNumber)
	 {
		 this._phoneNumber=ContactNumber;
	 }
	
	

}
