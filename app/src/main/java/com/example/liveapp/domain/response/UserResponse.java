package com.example.liveapp.domain.response;

import com.example.liveapp.ui.models.UserModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("categories")
    @Expose
    private List<UserModel> categories = null;

    public List<UserModel> getCategories() {
        return categories;
    }

    public void setCategories(List<UserModel> categories) {
        this.categories = categories;
    }
}
