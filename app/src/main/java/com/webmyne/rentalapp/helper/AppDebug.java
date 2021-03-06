package com.webmyne.rentalapp.helper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;

/**
 * The App debug.
 */
public class AppDebug
{
    private static final X500Principal DEBUG_DN = new X500Principal("CN=Android Debug,O=Android,C=US");

    /**
     * Is debuggable boolean.
     *
     * @param ctx the ctx
     * @return the boolean
     */
    public boolean isDebuggable(Context ctx)
    {
        boolean debuggable = false;
        try
        {
            PackageInfo pInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), PackageManager.GET_SIGNATURES);
            Signature[] signatures = pInfo.signatures;
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            for (Signature signature : signatures)
            {
                ByteArrayInputStream stream = new ByteArrayInputStream(signature.toByteArray());
                X509Certificate cert = (X509Certificate) cf.generateCertificate(stream);
                debuggable = cert.getSubjectX500Principal().equals(DEBUG_DN);
                if (debuggable)
                {
                    break;
                }
            }
        }
        catch (PackageManager.NameNotFoundException | CertificateException e)
        {
            //debuggable variable will remain false
        }
        return debuggable;
    }
}
