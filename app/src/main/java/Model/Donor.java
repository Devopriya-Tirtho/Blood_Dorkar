package Model;

public class Donor {
    int _id;
    String _name;
    String _phoneNumber;
    String _address;
    String _age;
    private String _bloodgroup;




    public Donor(int Id,String Name ,String Bloodgroup, String Age ,  String Address, String PhoneNumber )
    {


        this._id=Id;
        this._name=Name;
        this._phoneNumber=PhoneNumber;
        this._address=Address;
        this._bloodgroup=Bloodgroup;
        this._age=Age;

    }

    public Donor(String Name ,String Bloodgroup, String Age ,  String Address, String PhoneNumber )
    {

        this._name=Name;
        this._phoneNumber=PhoneNumber;
        this._address=Address;
        this._bloodgroup=Bloodgroup;
        this._age=Age;

    }


    public Donor(String Name , String PhoneNumber)
    {

        this._name=Name;
        this._phoneNumber=PhoneNumber;

    }
    public Donor(String Name ,String Blood_grp, String PhoneNumber)
    {
        this._bloodgroup=Blood_grp;
        this._name=Name;
        this._phoneNumber=PhoneNumber;


    }


    public Donor(String Name ,String Blood_grp, String PhoneNumber,  String Address)
    {
        this._bloodgroup=Blood_grp;
        this._name=Name;
        this._phoneNumber=PhoneNumber;
        this._address=Address;

    }








    public Donor()
    {

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_age() {
        return _age;
    }

    public void set_age(String _age) {
        this._age = _age;
    }

    public String get_bloodgroup() {
        return _bloodgroup;
    }

    public void set_bloodgroup(String _bloodgroup) {
        this._bloodgroup = _bloodgroup;
    }



}
