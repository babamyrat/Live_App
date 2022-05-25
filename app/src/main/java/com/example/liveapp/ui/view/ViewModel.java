package com.example.liveapp.ui.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.liveapp.domain.repository.UserRepository;
import com.example.liveapp.ui.models.UserModel;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private UserRepository mRepo = UserRepository.getInstance(getApplication());

    private MutableLiveData<List<UserModel>> mDataList = new MutableLiveData<>();

    public MutableLiveData<List<UserModel>> getLiveDate() {
        return mDataList;
    }

    public ViewModel(@NonNull Application application) {
        super(application);
    }

    public void getUserModel(){
        mRepo.loadCategory(mDataList);
    }
}
