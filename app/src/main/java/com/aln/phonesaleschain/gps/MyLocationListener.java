package com.aln.phonesaleschain.gps;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.aln.phonesaleschain.datahelper.webapi.APIUtils;
import com.aln.phonesaleschain.datahelper.webapi.PathApi;
import com.aln.phonesaleschain.model.ResponseSavePosition;
import com.aln.phonesaleschain.service.WakeServiceSSk;
import com.aln.phonesaleschain.utilities.UtilBasic;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyLocationListener implements LocationListener {
    public Location previousBestLocation;
    private CurrentPosition myLocation;

    public static final int PER_TIME = 1*70*1000;
    public static final int MIN_DISTANCE = 0;
    private Context mCTX;
    private PathApi mService;
    private afterSendLoc sendone;
    public boolean flag = false;

    public MyLocationListener(Context ctx, afterSendLoc call) {
        mCTX = ctx;
        sendone = call;
    }

    public void onLocationChanged(final Location loc) {
        Log.e("<<<location change", "Myloctionchange: " + loc.getLatitude());
        if (isBetterLocation(loc, previousBestLocation)) {
            Log.e("<<<IsBesster change", "Myloctionchange");
            setMyLocation(loc,WakeServiceSSk.empCode);

            Location company = new Location("");
            company.setLatitude(10.729389);
            company.setLongitude(106.721850);

            Location curentLocate = new Location("");
            curentLocate.setLatitude(myLocation.getLatitue());
            curentLocate.setLongitude(myLocation.getLongitue());

//            float distanceInMeters = company.distanceTo(curentLocate);
//                if(distanceInMeters > 50)
//                {
//                    SendLocation(myLocation);
//                }
            Date d = new Date();
            Calendar cc = Calendar.getInstance();
            int hh = cc.get(Calendar.HOUR_OF_DAY);
            if(hh<8||hh>22)
            {
                return;
            }
            SendLocation(myLocation);
        }
    }

    public CurrentPosition setMyLocation(Location loc, String empCode) {
        myLocation = new CurrentPosition();
        myLocation.setLongitue(loc.getLongitude());
        myLocation.setLatitue(loc.getLatitude());
        myLocation.setMaNV(empCode);
        myLocation.setDate(UtilBasic.get_yyyyMMddHHmmss().format(Calendar.getInstance().getTime()));
        myLocation.setAddress(GetAddress(loc));
        return myLocation;
    }

    private boolean isSameProvider(String provider1, String provider2) {
        if (provider1 == null) {
            return provider2 == null;
        }
        return provider1.equals(provider2);
    }

    public boolean isBetterLocation(Location location, Location currentBestLocation) {
        if (currentBestLocation == null) {
            return true;
        }
        Log.e("<<<isBetterLocation", location.getLatitude() + "");
        long timeDelta = location.getTime() - currentBestLocation.getTime();
        boolean isSignificantlyNewer = timeDelta > PER_TIME;
        boolean isSignificantlyOlder = timeDelta < -PER_TIME;
        boolean isNewer = timeDelta > 0;

        if (isSignificantlyNewer) {
            return true;
        } else if (isSignificantlyOlder) {
            return false;
        }

        int accuracyDelta = (int) (location.getAccuracy() - currentBestLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0;
        boolean isMoreAccurate = accuracyDelta < 0;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200;

        boolean isFromSameProvider = isSameProvider(location.getProvider(),
                currentBestLocation.getProvider());

        if (isMoreAccurate) {
            return true;
        } else if (isNewer && !isLessAccurate) {
            return true;
        } else if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {
            return true;
        }

        return false;
    }

    public String GetAddress(Location location) {
        try {
            Geocoder geocoder = new Geocoder(mCTX, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            return addresses.get(0).getAddressLine(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    public void onProviderDisabled(String provider) {
        Toast.makeText(mCTX, "Gps Disabled", Toast.LENGTH_SHORT).show();
    }

    public void onProviderEnabled(String provider) {
        Toast.makeText(mCTX, "Gps Enabled", Toast.LENGTH_SHORT).show();
    }

    public void SendLocation(CurrentPosition currentPosition) {
        Calendar cc = Calendar.getInstance();
        int hh = cc.get(Calendar.HOUR_OF_DAY);
        if(hh<7||hh>22)
            return;

        Log.e("<<thanhserver", "sendservice");
        mService = APIUtils.getService();
        if (flag == false)
        {
            flag = true;
            mService.savePosition(currentPosition.getMaNV(),currentPosition.getLatitue(),currentPosition.getLongitue(),currentPosition.getAddress()).enqueue(new Callback<ResponseSavePosition>() {
                @Override
                public void onResponse(Call<ResponseSavePosition> call, Response<ResponseSavePosition> response) {
                    response.body();
                    flag = false;
                    Log.e("<<thanhserver", response.message());
                }

                @Override
                public void onFailure(Call<ResponseSavePosition> call, Throwable t) {
                    Log.e("<<errror knguyen", t.getMessage());
                    flag = false;
                }
            });
        }

    }

    public interface afterSendLoc {
        void cancelNow();
        void setLooping();
        boolean requestMyLoc();
        void repeatMyLoc();

    }
}
