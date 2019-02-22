package cordova.plugin.imox;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.concurrent.TimeUnit;

import io.imox.deviceinfo.DeviceInfo;

/**
 * This class echoes a string called from JavaScript.
 */
public class ImoxPlugin extends CordovaPlugin {

    private int brand;
    private int timeRecolecData;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        //final JSONObject arg_object = args.getJSONObject(0);

        //brand = Integer.parseInt(arg_object.getString("Brand"));
        //timeRecolecData = Integer.parseInt(arg_object.getString("TimeRecolecData"));

        if (action.equals("startSdk")) {
            String message = args.getString(0);
            this.startSdk(message, callbackContext);
            return true;
        }

        if (action.equals("forceRecolec")) {
            String message = args.getString(0);
            this.forceRecolec(message, callbackContext);
            return true;
        }

        return false;
    }

    private void startSdk(String message, CallbackContext callbackContext) {

        DeviceInfo.getInstance()
                .setIdBrand(81)
                .setTimeRecolecData(1, TimeUnit.DAYS)
                .load (this.cordova.getActivity());

        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void forceRecolec(String message, CallbackContext callbackContext) {

        DeviceInfo.getInstance().forceRecolec();

        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
