package com.webmyne.rentalapp.helper;



import java.util.regex.Pattern;

/**
 * Common util class to perform all action on strings
 */
public class AppTextUtils
{

    /**
     * This method is used to check is email is valid or not.
     *
     * @param email email of user
     * @return boolean that email is valid or not
     */
    public boolean isValidEmailAddress(String email)
    {
        return Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}").matcher(email).matches();
    }


    /**
     * This method is used to check is phone number is valid or not.
     *
     * @param contactNo   number of user
     * @param countryCode the country code
     * @return boolean that email is valid or not
     */
    /*public boolean isValidPhone(String contactNo, int countryCode)
    {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try
        {
            String countryIsoCode = phoneUtil.getRegionCodeForCountryCode(countryCode);
            return phoneUtil.isValidNumberForRegion(phoneUtil.parse(contactNo, countryIsoCode), countryIsoCode);
        }
        catch (NumberParseException e)
        {
            Crashlytics.logException(e);
            return false;
        }
    }*/
}
