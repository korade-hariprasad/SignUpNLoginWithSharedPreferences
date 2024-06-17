package sumago.androidipt.day10b2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPref {

    Context context;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String KEY_NAME="name";
    public static final String KEY_MOBILE="mobile";
    public static final String KEY_PASSWORD="password";
    public static final String KEY_IS_LOGIN="login";

    public MyPref(Context context) {
        this.context = context;
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
    }
    public void setName(String  name)
    {
        editor.putString(KEY_NAME,name);
        editor.apply();
    }

    public String getName(){

        return sharedPreferences.getString(KEY_NAME,"default");
    }

    public void setMobile(String  mobile)
    {
        editor.putString(KEY_MOBILE,mobile);
        editor.apply();
    }

    public String getMobile(){

        return sharedPreferences.getString(KEY_MOBILE,"default");
    }
    public void setPassword(String  password)
    {
        editor.putString(KEY_PASSWORD,password);
        editor.apply();
    }

    public String getPassword(){

        return sharedPreferences.getString(KEY_PASSWORD,"default");
    }

    public void setIsLogin(boolean  status)
    {
        editor.putBoolean(KEY_IS_LOGIN,status);
        editor.apply();
    }

    public boolean getIsLogin(){

        return sharedPreferences.getBoolean(KEY_IS_LOGIN,false);
    }

    public void clearAll()
    {
        editor.clear();
        editor.apply();
    }


}
