package com.example.liveapp.domain.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.liveapp.data.api.ApiClient;
import com.example.liveapp.ui.models.UserModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {
    private Context context;
    private static UserRepository instance;
    private ArrayList<UserModel>  userModels = new ArrayList<>();
    private ApiClient apiClient;

    public UserRepository(Context context) {
        this.context = context;
        apiClient = ApiClient.newInstance();

    }

    public static UserRepository getInstance(Context context) {
        if (instance == null) {
            instance = new UserRepository(context);
        }
        return instance;
    }


    public void loadCategory(MutableLiveData<List<UserModel>> liveData) {
        //REST api
        apiClient.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userResponse -> {
                    liveData.postValue(userResponse.getCategories());

                }, error -> Log.d("ERROR", error.getMessage()));

    }
}
