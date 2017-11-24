package com.isil.am2template.storage.request.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AndresCyTz on 24/11/2017.
 */
/*
{
    "ownerId": "12961371-61F1-E274-FFE1-844E39B11400",
    "updated": null,
    "name": "Andres Caycho",
    "created": 1511554327279,
    "email": "acaycho@mail.com",
    "objectId": "12961371-61F1-E274-FFE1-844E39B11400",
    "userStatus": "ENABLED",
    "lastLogin": 1511554522836,
    "___class": "Users",
    "__meta": "{\"relationRemovalIds\":{},\"selectedProperties\":[\"ownerId\",\"updated\",\"name\",\"created\",\"email\",\"objectId\",\"password\",\"userStatus\",\"lastLogin\",\"__updated__meta\",\"___class\"],\"relatedObjects\":{}}",
    "user-token": "77D41E59-B75D-1B13-FFCF-BF8F235EC000"
}
 */
public class LogInResponse {
    private String objectId;
    private String email;
    private String name;

    @SerializedName("user-token")
    private String token;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
