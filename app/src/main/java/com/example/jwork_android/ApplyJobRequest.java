package com.example.jwork_android;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.*;

public class ApplyJobRequest extends StringRequest {
    private static final String URL_Ewallet = "http://192.168.43.88:8080/invoice/createEWalletPayment";
    private static final String URL_Bank = "http://192.168.43.88:8080/invoice/createBankPayment";
    private Map<String, String> params;

    public ApplyJobRequest(String jobList, String jobseekerId, String refferalCode, Response.Listener<String> listener) {
        super(Method.POST, URL_Ewallet, listener, null);
        params = new HashMap<>();
        params.put("jobIdList", jobList);
        params.put("jobseekerId", jobseekerId);
        params.put("referralCode", refferalCode);
    }

    public ApplyJobRequest(String jobList, String jobseekerId, Response.Listener<String> listener) {
        super(Method.POST, URL_Bank, listener, null);
        params = new HashMap<>();
        params.put("jobIdList", jobList);
        params.put("jobseekerId", jobseekerId);
        params.put("adminFee", "5000");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
