package com.example.meallist.managers


import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.provider.Settings
import android.view.inputmethod.InputMethodManager

import java.io.UnsupportedEncodingException
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.crypto.*

class Helpers {


    companion object {
        private var instance: Helpers? = null

        val shared: Helpers
            get() {
                if (instance == null) {
                    instance = Helpers()
                }

                return instance!!
            }
    }


    fun Log(text:String) {
        android.util.Log.i("",text)
    }

    fun getAndroidVersion(): String {
        val release = Build.VERSION.RELEASE
        val sdkVersion = Build.VERSION.SDK_INT
        return "$sdkVersion ($release)"
    }


    fun getUniqueDeviceId(context: Context?): String {
        if (context == null)
        {
            return ""
        }

        val deviceId = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        if(!deviceId.isNullOrBlank())
        {
            return deviceId
        }

        return ""
    }


    fun getSharedPrefences(): SharedPreferences {
        val ctx:Context = BaseApplication.getContext()
        val mSharedPreferences = ctx.getSharedPreferences("", Context.MODE_PRIVATE)
        return mSharedPreferences
    }

    fun getRandomString(sizeOfRandomString: Int): String {
        val ALLOWED_CHARACTERS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val random = Random()
        val sb = StringBuilder(sizeOfRandomString)
        for (i in 0 until sizeOfRandomString) sb.append(
            ALLOWED_CHARACTERS[random.nextInt(
                ALLOWED_CHARACTERS.length
            )]
        )
        return sb.toString()
    }

    fun checkData(body: String, data_key: String): String {
        try {
            val plainBody: String = body
            val hashedBody: String = plainBody
            if (hashedBody == data_key) {
                return plainBody
            }
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: NoSuchPaddingException) {
            e.printStackTrace()
        } catch (e: InvalidKeyException) {
            e.printStackTrace()
        } catch (e: InvalidAlgorithmParameterException) {
            e.printStackTrace()
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        } catch (e: BadPaddingException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }


    fun getFromattedTime(): String {
        val date: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        date.timeZone = TimeZone.getTimeZone("Greenwich")
        println("22222222 " + date.format(Date()))
        return date.format(Date())
    }


    fun saveLoginInfo(key: String, s: String) {

        val ctx:Context = BaseApplication.getContext()

        var encrypted = ""
        try {
            encrypted = s
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: NoSuchPaddingException) {
            e.printStackTrace()
        } catch (e: InvalidKeyException) {
            e.printStackTrace()
        } catch (e: InvalidAlgorithmParameterException) {
            e.printStackTrace()
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        } catch (e: BadPaddingException) {
            e.printStackTrace()
        }
        val editor: SharedPreferences.Editor = shared.getSharedPrefences().edit()
        editor.putString(key, encrypted)
        editor.apply()
    }

    fun getLoginInfo(key: String): String {
        val ctx:Context = BaseApplication.getContext()

        if (shared.getSharedPrefences() == null) {
            return ""
        } else if (!shared.getSharedPrefences().contains(key)) {
            return ""
        } else if (shared.getSharedPrefences().getString(key, "").equals("")) {
            return ""
        } else {
            try {
                val value = shared.getSharedPrefences().getString(key, "")
                if(value.isNullOrBlank())
                {
                    return ""
                }
                return value
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            } catch (e: NoSuchPaddingException) {
                e.printStackTrace()
            } catch (e: InvalidKeyException) {
                e.printStackTrace()
            } catch (e: InvalidAlgorithmParameterException) {
                e.printStackTrace()
            } catch (e: IllegalBlockSizeException) {
                e.printStackTrace()
            } catch (e: BadPaddingException) {
                e.printStackTrace()
            }
        }
        return ""
    }


    fun clearLoginInfo() {
        val ctx:Context = BaseApplication.getContext()

        val editor: SharedPreferences.Editor = shared.getSharedPrefences().edit()
        editor.putString("UserId", "")
        editor.putString("Email", "")
        editor.putString("Name", "")
        editor.putString("Surname", "")
        editor.putString("Token", "")
        editor.putString("Salt", "")
        editor.putString("Secret", "")
        editor.putString("Pin", "")
        editor.putString("MobilePin", "")
        editor.apply()
    }

    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
        if (inputMethodManager.isActive) {
            if (activity.currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(
                    activity.currentFocus!!.windowToken, 0
                )
            }
        }
    }

}